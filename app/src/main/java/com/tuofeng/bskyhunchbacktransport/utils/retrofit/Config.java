package com.tuofeng.bskyhunchbacktransport.utils.retrofit;

import static com.tuofeng.bskyhunchbacktransport.ui.activity.BaseApplication.mIsTestFlage;

public class Config {

    public static String baseUrl = mIsTestFlage ? "https://testcloudtransportauth.bjtftech.com" : "";

    //----------------------------登录Start----------------------------
    public static String gPhonePwdUrl = baseUrl + "/api/Authentication/password/login";//用户名密码登录

    //----------------------------登录End----------------------------

    //----------------------------用户信息Start----------------------------

    //----------------------------用户信息End----------------------------

    //----------------------------任务相关接口Start----------------------------

    //----------------------------任务相关接口End----------------------------

    //----------------------------异常接口Start----------------------------
    //----------------------------异常接口End----------------------------
}
