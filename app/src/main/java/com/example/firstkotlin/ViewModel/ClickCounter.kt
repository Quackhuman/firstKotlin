package com.example.firstkotlin.ViewModel

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.firstkotlin.R

class ClickCounter : AppCompatActivity() {

    lateinit var viewModel: ClickCounterVM

    //延迟初始化，从轻量数据库取数据的
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clickcounter)

        //创建sp的示例，不过传递的常数并不知道是什么
        sp = getSharedPreferences("data", MODE_PRIVATE)

        //为counterReserved设置初始的值
        val counterReserved = sp.getInt("counter_reserved", 3)

        //创建VM实例
        viewModel = ViewModelProvider(this,ClickCounterViewModelFactory(counterReserved)).get(ClickCounterVM::class.java)

        //设置按钮监听
        val onPlusOne =  findViewById<Button>(R.id.plusOneBtn)
        onPlusOne.setOnClickListener {
            viewModel.counter++
            refreshCounter()
        }

        val clearBtn = findViewById<Button>(R.id.clearBtn)
        clearBtn.setOnClickListener {
            viewModel.counter = 0
            refreshCounter()
        }
        refreshCounter()
    }

    private fun refreshCounter() {
        val infotext = findViewById<TextView>(R.id.infoText)
        infotext. text = viewModel.counter.toString()
    }

    /*
    * override fun onPause() {：这是 onPause() 方法的重写，它是 Android 生命周期的一部分。当应用程序失去焦点或进入后台时，系统会调用 onPause() 方法。
    * super.onPause()：这是调用父类的 onPause() 方法，以确保执行父类中的相关逻辑。通常，在重写生命周期方法时，我们会调用父类的方法。
    * sp.edit {：这里的 sp 是一个 SharedPreferences 对象的实例，用于获取和修改 SharedPreferences 数据。通过调用 edit() 方法，我们获得了一个 SharedPreferences.Editor 对象，用于进行修改操作。
    * putInt("count_reserved", viewModel.counter)：这行代码使用 putInt() 方法将名为 "count_reserved" 的键和 viewModel.counter 的值存储到 SharedPreferences 中。viewModel.counter 是一个 ViewModel 中的计数器属性，它的值将被保存。
    * */
    override fun onPause() {
        super.onPause()
        sp.edit() {
            putInt("counter_reserved", viewModel.counter)
        }
    }
}