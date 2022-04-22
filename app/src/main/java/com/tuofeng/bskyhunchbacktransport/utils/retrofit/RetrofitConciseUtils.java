package com.tuofeng.bskyhunchbacktransport.utils.retrofit;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.tuofeng.bskyhunchbacktransport.base.IView;
import com.tuofeng.bskyhunchbacktransport.base.MyDealWithJsonDataI;
import com.tuofeng.bskyhunchbacktransport.module.bean.BaseBean;
import com.tuofeng.bskyhunchbacktransport.module.bean.ErrorJsonBean;
import com.tuofeng.bskyhunchbacktransport.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class RetrofitConciseUtils {

    public static void dealWithJsonData(IView iView, String data, BaseBean baseBean, MyDealWithJsonDataI correctCall) {//无需解析数据异常做处理时调用
        dealWithJsonData(iView, data, baseBean, correctCall, baseBean1 -> {
        });
    }

    public static void dealWithJsonData(IView iView, String data, BaseBean baseBean, MyDealWithJsonDataI correctCall, MyDealWithJsonDataI errorCall) {
        try {
            //iView.dismissLoadingDialog();
            if (TextUtils.isEmpty(data)) {
                correctCall.dealWithCall(baseBean);
                return;
            }
            JSONObject object = new JSONObject(data);
            boolean error = object.has("error");
            BaseBean bean = null;
            if (error) {
                int endIndex = data.indexOf("+");
                String dataString = data.substring(0, endIndex);
                String codeString = data.substring(endIndex + 1, data.length());

                ToastUtil.showFixedJSONToast(dataString);
                ErrorJsonBean.ErrorBean errorBean = new ErrorJsonBean.ErrorBean();
                errorBean.setCode(codeString);
                errorCall.dealWithCall(errorBean);
            } else {
                if (baseBean != null) {
                    Gson gson = new Gson();
                    bean = gson.fromJson(data, baseBean.getClass());
                }
                correctCall.dealWithCall(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtil.shortUniteErrorToast();
            errorCall.dealWithCall(null);
        }
    }

    public static MediaType getMediaTypeType(int type) {
        MediaType mediaType = null;
        if (type == 0) {
            mediaType = MediaType.parse("text/plain");
        } else if (type == 1) {
            mediaType = MediaType.parse("image/png");
        } else if (type == 2) {
            mediaType = MediaType.parse("application/json");
        }
        return mediaType;
    }

    private static RequestBody getRequestBody(String data) {
        return getRequestBody(0, data);
    }

    public static RequestBody getRequestBody(int type, String o) {
        return RequestBody.create(getMediaTypeType(type), o);
    }

    /*public static void postUploadImage(List<String> imagePathList, String url, IView view, final ICallBack success) {
        Map<String, RequestBody> params = new HashMap<>();
        params.put("isSeal", getRequestBody("true"));

        for (int i = 0; i < imagePathList.size(); i++) {
            File file = new File(imagePathList.get(i));
            RequestBody requestFile = RequestBody.create(RetrofitConciseUtils.getMediaTypeType(1), file);
            params.put("file" + i + "\";filename=\"" + file.getName(), requestFile);
        }
        RetrofitConciseUtils.post(url, params, success, str -> {
            view.dismissLoadingDialog();
            ToastUtil.shortUniteErrorToast();
        });
    }

    public static void postCoordinate(final String cUrl, IView view, final ICallBack success) {
        postRaw(cUrl, addPositionRequestBody(), success, str -> {
            view.dismissLoadingDialog();
            ToastUtil.shortUniteErrorToast();
        });
    }

    public static void get(final String cUrl, IView view, final ICallBack success) {
        get(cUrl, success, str -> {
            view.dismissLoadingDialog();
            ToastUtil.shortUniteErrorToast();
        });
    }

    public static void get(final String cUrl, IView view, final ICallBack success,final ICallBack error) {
        get(cUrl, success, str -> {
            error.result("");
            view.dismissLoadingDialog();
            ToastUtil.shortUniteErrorToast();
        });
    }*/

    public static void get(final String cUrl, final ICallBack success, final ICallBack error) {
        Call<ResponseBody> call = RetrofitApiBean.getInstance().service.get(cUrl);
        call.enqueue(new MyCallback(success, error));
    }

    public static void post(final String cUrl, Map<String, RequestBody> params, final ICallBack success, final ICallBack error) {
        Call<ResponseBody> call = RetrofitApiBean.getInstance().service.post(cUrl, params);
        call.enqueue(new MyCallback(success, error));
    }

    public static void put(final String cUrl, @Body RequestBody route, final ICallBack success, final ICallBack error) {
        Call<ResponseBody> call = RetrofitApiBean.getInstance().service.put(cUrl, route);
        call.enqueue(new MyCallback(success, error));
    }

    public static void postRaw(final String cUrl, @Body RequestBody route, final ICallBack success) {
        postRaw(cUrl, route, (IView) null, success);
    }

    public static void postRaw(final String cUrl, @Body RequestBody route, IView view, final ICallBack success) {
        postRaw(cUrl, route, success, str -> {
            ToastUtil.shortUniteErrorToast();
        });
    }

    private static void postRaw(final String cUrl, @Body RequestBody route, final ICallBack success, final ICallBack error) {
        Call<ResponseBody> call = RetrofitApiBean.getInstance().service.postRaw(cUrl, route);
        call.enqueue(new MyCallback(success, error));
    }

    private static class MyCallback implements Callback<ResponseBody> {
        private final ICallBack success;
        private final ICallBack error;

        private MyCallback(ICallBack success, ICallBack error) {
            this.success = success;
            this.error = error;
        }

        @Override
        public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
            try {
                ResponseBody body = response.body();
                if (response.isSuccessful()) {
                    String result = "";
                    if (body != null) {
                        result = body.string();
                    }
                    success.result(result);
                } else {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        String string = responseBody.string() + "+" + response.code();
                        success.result(string);
                    } else {
                        error.result("");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                error.result(e.toString());
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            String s = t.toString();
            error.result(s);
        }
    }
}