package com.example.loginapp.models

import android.hardware.camera2.CaptureFailure
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Parcelize
data class LoginResponseData(

    var token: UserToken,
    var data: ArrayList<LoginData>,
    val msg:String ,
    val msg_code:String

) : Parcelable