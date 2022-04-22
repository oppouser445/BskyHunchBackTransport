package com.tuofeng.bskyhunchbacktransport.module.data;

import static com.tuofeng.bskyhunchbacktransport.utils.retrofit.RetrofitConciseUtils.dealWithJsonData;
import static com.tuofeng.bskyhunchbacktransport.utils.retrofit.RetrofitConciseUtils.getMediaTypeType;

import android.text.TextUtils;

import com.tuofeng.bskyhunchbacktransport.base.MyDealWithJsonDataI;
import com.tuofeng.bskyhunchbacktransport.contract.LoginContract;
import com.tuofeng.bskyhunchbacktransport.in.BaseDataSource;
import com.tuofeng.bskyhunchbacktransport.module.bean.BaseBean;
import com.tuofeng.bskyhunchbacktransport.module.bean.LoginBean;
import com.tuofeng.bskyhunchbacktransport.module.bean.UserBean;
import com.tuofeng.bskyhunchbacktransport.utils.UserSPUtil;
import com.tuofeng.bskyhunchbacktransport.utils.retrofit.Config;
import com.tuofeng.bskyhunchbacktransport.utils.retrofit.ICallBack;
import com.tuofeng.bskyhunchbacktransport.utils.retrofit.RetrofitConciseUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class LoginRepository implements BaseDataSource {

    private final String TAG = "LoginRepository";

    public void loginUser(UserBean userBean, String url, LoginContract.ILoginRepository correctCall) {
        try {
            String urlData = "";
            JSONObject object = new JSONObject();
            String cod = userBean.getCod();
            if (!TextUtils.isEmpty(cod)) {
                urlData = Config.gPhoneCodUrl;
                object.put("phoneNumber", userBean.getPhone());
                object.put("code", userBean.getCod());
            } else {
                urlData = Config.gPhonePwdUrl;
                object.put("userPhone", /*userBean.getPhone()*/"admin");
                object.put("pwd", /*userBean.getPwd()*/"1q2w3E*");
            }

            RetrofitConciseUtils.postRaw(urlData, RequestBody.create(getMediaTypeType(2), object.toString()), str -> {
                dealWithJsonData(null, str, new LoginBean(), baseBean -> {
                    LoginBean loginBean = (LoginBean) baseBean;
                    UserSPUtil.setUserData(str);
                    String access_token = loginBean.getAccess_token();
                    UserSPUtil.setUserToken(access_token);
                    if (!TextUtils.isEmpty(access_token)) {
                        correctCall.startHomeActivity();
                    }
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}