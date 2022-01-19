package com.tuofeng.bskyhunchbacktransport.utils.retrofit;


import com.tuofeng.bskyhunchbacktransport.ui.activity.BaseApplication;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiBean {
    private static RetrofitApiBean instance;
    public RetrofitApi service;
    private static final int MTIMEOUT = 10000;

    private RetrofitApiBean(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        service = retrofit.create(RetrofitApi.class);
    }

    public static RetrofitApiBean getInstance() {
        if (instance == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(MTIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
                    .readTimeout(MTIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
                    .addInterceptor(new HeaderInterceptor(BaseApplication.getInstance()))
                    .build();
            instance = new RetrofitApiBean(client);
        }
        return instance;
    }
}
