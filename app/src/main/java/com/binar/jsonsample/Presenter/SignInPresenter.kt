package com.binar.jsonsample.Presenter

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.binar.jsonsample.LoginFragmentDirections
import com.binar.jsonsample.data.LoginAdmin
import com.binar.jsonsample.model.AdminLoginResponse
import com.binar.jsonsample.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInPresenter(private var viewInterface: SignInContract.viewInterface,):SignInContract.PresenterInterface {
    override fun signIn(loginAdmin: LoginAdmin) {
        ApiClient.instance.loginAdmin(loginAdmin)
            .enqueue(object : Callback<AdminLoginResponse> {
                override fun onResponse(
                    call: Call<AdminLoginResponse>,
                    response: Response<AdminLoginResponse>
                ) {
                    val codeResult=response.code()
                    viewInterface.resultCode(codeResult)

                }

                override fun onFailure(call: Call<AdminLoginResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }


}