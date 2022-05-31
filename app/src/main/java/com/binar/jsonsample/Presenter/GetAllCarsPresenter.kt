package com.binar.jsonsample.Presenter

import android.util.Log
import com.binar.jsonsample.model.getAllCarResponseItem
import com.binar.jsonsample.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetAllCarsPresenter (private  var viewInterface:GetAllCarsContract.viewInterface): GetAllCarsContract.PresenterInterface{
    override fun getAllCars() {
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<getAllCarResponseItem>> {
                override fun onResponse(
                    call: Call<List<getAllCarResponseItem>>,
                    response: Response<List<getAllCarResponseItem>>
                ) {
                    val result= response.body()
                    val code = response.code()
                    viewInterface.showResult(result)
                    viewInterface.showCode(code)

                }
                override fun onFailure(call: Call<List<getAllCarResponseItem>>, t: Throwable) {
                    Log.d("home", "fail")
                }


            })
    }
}