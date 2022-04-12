package com.binar.jsonsample.service

import com.binar.jsonsample.model.getAllCarResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("admin/car")
    fun getAllCar(): Call<List<getAllCarResponseItem>>
}