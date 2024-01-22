package com.example.firstkotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//这段代码很多不会的，交给以后的我吧
class ClickCounterViewModelFactory(private val countReserved: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ClickCounterVM(countReserved) as T
    }

}