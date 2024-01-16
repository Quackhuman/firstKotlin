package com.example.firstkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_layout)
        val extraData = intent.getStringExtra("extra_data")
        Log.d("页面3","页面2传过来的值是 $extraData")
    }


}