package com.tuofeng.bskyhunchbacktransport.module.data;

import com.tuofeng.bskyhunchbacktransport.base.MyDealWithJsonDataI;
import com.tuofeng.bskyhunchbacktransport.in.BaseDataSource;
import com.tuofeng.bskyhunchbacktransport.module.bean.BaseBean;
import com.tuofeng.bskyhunchbacktransport.module.bean.UserBean;
import com.tuofeng.bskyhunchbacktransport.utils.retrofit.Config;
import com.tuofeng.bskyhunchbacktransport.utils.retrofit.ICallBack;
import com.tuofeng.bskyhunchbacktransport.utils.retrofit.RetrofitConciseUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class LoginRepository implements BaseDataSource {

    private final String TAG = "LoginRepository";

    public void loginUser(UserBean userBean, String url, MyDealWithJsonDataI correctCall, MyDealWithJsonDataI errorCall) {
        try {

            Map<String, RequestBody> params = new HashMap<>();
            MediaType textType = RetrofitConciseUtils.getMediaTypeType(1);
            params.put("userPhone", RequestBody.create(textType, userBean.getPhone()));
            params.put("pwd", RequestBody.create(textType, userBean.getPwd()));

            RetrofitConciseUtils.post(Config.gPhonePwdUrl, params, str -> {

            }, str -> {

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}