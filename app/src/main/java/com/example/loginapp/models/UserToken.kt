package com.example.loginapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserToken(

     var access_token: String,
     var token_type: String,
     var expires_in: String,
     var refresh_token: String,
     var scope: String

) : Parcelable