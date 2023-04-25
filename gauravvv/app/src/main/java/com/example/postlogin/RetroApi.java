package com.example.postlogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetroApi {

    @FormUrlEncoded
    @POST("userdata/rrrrrrr.php")
    Call<Model> ragister(@Field("name") String name,@Field("email")String email,@Field("password")String password);


    @FormUrlEncoded
    @POST("userdata/mmm.php")
    Call<Model> login(@Field("email")String email,@Field("password")String password);
}
