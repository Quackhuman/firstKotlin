package com.example.firstkotlin.ViewModel

import androidx.lifecycle.ViewModel

class ClickCounterVM(countReserved: Int) : ViewModel() {
    var counter = countReserved
}