package com.example.loginapp.models

data class LoginResponse(val token:UserToken, val data:LoginData , val msg:String , val msg_code:String)