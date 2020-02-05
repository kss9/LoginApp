package com.example.loginapp.api

import com.example.loginapp.models.LoginResponse
import com.example.loginapp.models.LoginResponseData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface Api {


    @FormUrlEncoded
    @POST("login/")
    fun userLogin(
        @Field("app_name") app_name:String,
        @Field("app_version") app_version:String,
        @Field("device_id") device_id:String,
        @Field("username") username:String,
        @Field("password") password: String

    ):Call<LoginResponseData>
}