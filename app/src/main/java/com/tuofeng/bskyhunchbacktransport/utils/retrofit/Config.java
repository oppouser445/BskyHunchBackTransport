package com.tuofeng.bskyhunchbacktransport.utils.retrofit;

import static com.tuofeng.bskyhunchbacktransport.ui.activity.BaseApplication.mIsTestFlage;

public class Config {

    /*2CDD4678-0CEB-56E5-C72A-3A023C839C35 货主
      911DFA74-74DB-52B3-1E88-3A023C845620 后台运营管理
      FA54BC53-FF20-1E15-EBBC-3A023C84ACB7 司机
      62614DA1-B904-1A13-CE72-3A023C84F6F9 车队长*/

    public static String baseUrl = mIsTestFlage ? "https://testcloudtransportauth.bjtftech.com" : "";

    //----------------------------登录Start----------------------------
    public static String gPhonePwdUrl = baseUrl + "/api/Authentication/password/login";//用户名密码登录
    public static String gPhoneCodUrl = baseUrl + "/api/Authentication/sms/login";//短信验证码登录

    /*FA54BC53-FF20-1E15-EBBC-3A023C84ACB7 司机
    62614DA1-B904-1A13-CE72-3A023C84F6F9 车队长*/

    //----------------------------登录End----------------------------

    //----------------------------用户信息Start----------------------------

    //----------------------------用户信息End----------------------------

    //----------------------------任务相关接口Start----------------------------

    //----------------------------任务相关接口End----------------------------

    //----------------------------异常接口Start----------------------------
    //----------------------------异常接口End----------------------------
}
