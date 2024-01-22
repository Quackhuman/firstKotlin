package com.example.firstkotlin.ViewModel.VMLivingData

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firstkotlin.R

class ClickCounterLD:AppCompatActivity() {

    lateinit var viewModel: ClickCounterVMLD

    //延迟初始化，从轻量数据库取数据的
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clickcounter_ld)

        //创建sp的示例，不过传递的常数并不知道是什么
        sp = getSharedPreferences("data", MODE_PRIVATE)

        //为counterReserved设置初始的值
        val counterReserved = sp.getInt("counter_reserved", 3)

        //创建VM实例
        viewModel = ViewModelProvider(this, ClickCounterF(counterReserved)).get(
            ClickCounterVMLD::class.java)

        val plusOne = findViewById<Button>(R.id.plusOneBtn)
        plusOne.setOnClickListener {
            viewModel.plusOne()
        }

        val clear = findViewById<Button>(R.id.clearBtn)
        clear.setOnClickListener {
            viewModel.clear()
        }

        viewModel.counter.observe(this) { count ->
            val infoText = findViewById<TextView>(R.id.infoText)
            infoText.text = count.toString()
        }


    }

    override fun onPause() {
        super.onPause()
        sp.edit() {
            putInt("counter_reserved", viewModel.counter.value ?: 0)
        }
    }

}