package com.example.firstkotlin.ViewModel.VMLivingData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClickCounterVMLD(countReserved: Int) : ViewModel() {

    private val userLiveData = MutableLiveData<User>()

//    val userName: LiveData<String> = Transformations.map(userLiveData) { user -> "${user.frist}"

    //这里我暂时不能理解，交给后来的人吧
    val counter: LiveData<Int>
        get() = _counter

    private val _counter = MutableLiveData<Int>()

    //这里在init结构体中给counter设置数据，这样之前保存的计数值就可以在初始化的时候得到恢复
    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }

}