/*
package com.binar.jsonsample

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.jsonsample.databinding.FragmentHomeBinding
import com.binar.jsonsample.model.getAllCarResponseItem
import com.binar.jsonsample.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val cars: MutableLiveData<List<getAllCarResponseItem>>by lazy {
        MutableLiveData<List<getAllCarResponseItem>>().also {
            loadCars()
        }
    }

    private val respons: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().also {
            loadCars()
        }
    }

    fun getCars(): LiveData<List<getAllCarResponseItem>>{
        return cars
    }
    fun getCode(): LiveData<Int>{
        return respons
    }

   fun loadCars(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<getAllCarResponseItem>> {
                override fun onResponse(
                    call: Call<List<getAllCarResponseItem>>,
                    response: Response<List<getAllCarResponseItem>>
                ) {

                    cars.value = response.body()
                    respons.value= response.code()

                }
                override fun onFailure(call: Call<List<getAllCarResponseItem>>, t: Throwable) {
                    Log.d("home", "fail")
                }


            })
    }
}*/
