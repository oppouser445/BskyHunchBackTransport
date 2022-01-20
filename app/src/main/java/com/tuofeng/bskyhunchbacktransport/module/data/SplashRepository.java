package com.tuofeng.bskyhunchbacktransport.module.data;

import com.tuofeng.bskyhunchbacktransport.base.MyDealWithJsonDataI;
import com.tuofeng.bskyhunchbacktransport.in.SplashDataSource;
import com.tuofeng.bskyhunchbacktransport.module.bean.BaseBean;
import com.tuofeng.bskyhunchbacktransport.utils.retrofit.RetrofitConciseUtils;

public class SplashRepository implements SplashDataSource {

    private final String TAG= "SplashRepository";

    @Override
    public void getUserData(String url, MyDealWithJsonDataI correctCall,MyDealWithJsonDataI errorCall) {
        BaseBean<String> baseBean = new BaseBean<String>();
        RetrofitConciseUtils.get(url, str -> {
            baseBean.setData(str);
            correctCall.dealWithCall(baseBean);
        }, str -> {
            baseBean.setData("请求失败：" +str);
            errorCall.dealWithCall(baseBean);
        });
    }
}