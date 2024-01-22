package com.example.firstkotlin.ViewModel.VMLivingData

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClickCounterVMLD(countReserved :Int):ViewModel() {

    val counter = MutableLiveData<Int>()

    //这里在init结构体中给counter设置数据，这样之前保存的计数值就可以在初始化的时候得到恢复
    init {
        counter.value = countReserved
    }

    fun plusOne(){
        val count = counter.value?:0
        counter.value = count+1
    }

    fun clear(){
        counter.value = 0
    }




}