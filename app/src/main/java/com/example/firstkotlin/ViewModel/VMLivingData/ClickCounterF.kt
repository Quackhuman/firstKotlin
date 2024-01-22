package com.example.firstkotlin.ViewModel.VMLivingData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firstkotlin.ViewModel.ClickCounterVM


//这段代码很多不会的，交给以后的我吧
class ClickCounterF(private val countReserved: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ClickCounterVM(countReserved) as T
    }

}