package com.tuofeng.bskyhunchbacktransport.utils.retrofit;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

public interface RetrofitApi {

    @GET
    Call<ResponseBody> get(@Url String url);

    @POST
    @Multipart
    Call<ResponseBody> post(@Url String url, @PartMap Map<String, RequestBody> args);

    /**
     * Raw形式提交数据
     */
    @POST
    Call<ResponseBody> postRaw(@Url String url, @Body RequestBody route);

    /**
     * Put形式提交数据
     */
    @PUT
    Call<ResponseBody> put(@Url String url, @Body RequestBody route);
}