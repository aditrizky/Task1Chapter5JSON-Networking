package com.binar.jsonsample.Presenter

import com.binar.jsonsample.data.AdminRegister

class RegisterContract {
    interface presenterInterface{
        fun registerAdmin(adminRegister: AdminRegister)
    }
    interface viewInterface {
        fun resultCode(code:Int)
    }
}