package com.example.loginapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Parcelize
data class FailureResponse(

    var msg: String,
    var msg_code: Int

) : Parcelable