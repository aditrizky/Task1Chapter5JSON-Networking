package com.binar.jsonsample.service

import com.binar.jsonsample.data.AdminRegister
import com.binar.jsonsample.data.LoginAdmin
import com.binar.jsonsample.model.AdminLoginResponse
import com.binar.jsonsample.model.RegisterResponseItem
import com.binar.jsonsample.model.getAllCarResponseItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("admin/car")
    fun getAllCar(): Call<List<getAllCarResponseItem>>

    @POST("admin/auth/register")
    fun regsiterAdmin(@Body adminRegister: AdminRegister):Call<RegisterResponseItem>

    @POST("admin/auth/login")
    fun loginAdmin (@Body loginAdmin: LoginAdmin):Call<AdminLoginResponse>
}