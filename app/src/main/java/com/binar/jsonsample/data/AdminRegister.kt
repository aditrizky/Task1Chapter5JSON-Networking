package com.binar.jsonsample.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdminRegister(
    @SerializedName("email")
    val email: String?=null,
    @SerializedName("password")
    val password: String?=null,
    @SerializedName("role")
    val role: String?= "admin"
):Parcelable
