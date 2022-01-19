package com.tuofeng.bskyhunchbacktransport.utils.retrofit;

import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    private Context mContext;

    public HeaderInterceptor(Context context) {
        this.mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        /*try {
            String token = "Bearer " *//*+ UserSPUtil.getUserToken()*//*;
            builder.addHeader("Content-Type", "application/json; charset=utf-8");
            builder.addHeader("Authorization", token);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Response proceed = chain.proceed(builder.build());
        if (TextUtils.isEmpty(proceed.cacheControl().toString())){
            return proceed.newBuilder().addHeader("Cache-Control","max-age=60*60*24").build();
        }
        return proceed;
    }
}
