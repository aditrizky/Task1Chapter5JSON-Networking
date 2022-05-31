package com.binar.jsonsample.Presenter

import com.binar.jsonsample.data.LoginAdmin

class SignInContract {
    interface PresenterInterface{
        fun signIn(loginAdmin: LoginAdmin)
    }
    interface viewInterface{
        fun resultCode(code:Int)
    }
}