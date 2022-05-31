package com.binar.jsonsample.Presenter

import com.binar.jsonsample.model.getAllCarResponseItem

class GetAllCarsContract {

    interface PresenterInterface{
        fun  getAllCars()
    }
    interface viewInterface{
        fun showResult(result:List<getAllCarResponseItem>?)
        fun showCode (code:Int)
    }
}