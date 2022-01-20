package com.tuofeng.bskyhunchbacktransport.module.data;

import com.tuofeng.bskyhunchbacktransport.base.MyDealWithJsonDataI;
import com.tuofeng.bskyhunchbacktransport.in.BaseDataSource;
import com.tuofeng.bskyhunchbacktransport.module.bean.BaseBean;
import com.tuofeng.bskyhunchbacktransport.utils.retrofit.RetrofitConciseUtils;

public class MainRepository implements BaseDataSource {

    private final String TAG= "SplashRepository";

    public void loginUser(String url, MyDealWithJsonDataI correctCall,MyDealWithJsonDataI errorCall) {
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