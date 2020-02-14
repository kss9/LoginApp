package com.example.loginapp.api

import com.example.loginapp.models.LoginResponse
import com.example.loginapp.models.LoginResponseData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


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

    /*@Multipart
    @POST("customer-app/user/upload/profile-picture/")
    fun uploadProfilePic(
        @HeaderMap headerMap: Map<String, String>,

        @Part("app_name") appName: RequestBody,
        @Part("app_version") appVersion: RequestBody,

        @Part("device_id") deviceId: RequestBody,
        @Part user_profile_picture: MultipartBody.Part
    ): Call<MessageResponse>*/



}