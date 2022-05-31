package com.binar.jsonsample.Presenter


import android.util.Log
import com.binar.jsonsample.data.AdminRegister
import com.binar.jsonsample.model.RegisterResponseItem
import com.binar.jsonsample.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(private var viewInterface: RegisterContract.viewInterface):RegisterContract.presenterInterface {
    override fun registerAdmin(adminRegister: AdminRegister) {
        ApiClient.instance.regsiterAdmin(adminRegister)
            .enqueue(object  : Callback<RegisterResponseItem> {
                override fun onResponse(
                    call: Call<RegisterResponseItem>,
                    response: Response<RegisterResponseItem>
                ) {
                    val codeResult= response.code()
                    viewInterface.resultCode(codeResult)
                }

                override fun onFailure(call: Call<RegisterResponseItem>, t: Throwable) {
                    Log.d("fail", t.message.toString())
                }

            })
    }
}