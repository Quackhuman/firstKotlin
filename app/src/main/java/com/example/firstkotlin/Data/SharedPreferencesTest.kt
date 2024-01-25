package com.example.firstkotlin.Data

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstkotlin.R

class SharedPreferencesTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shared_preferences_test)

        //存储数据
        val saveBtn = findViewById<Button>(R.id.saveButton)
        saveBtn.setOnClickListener{
            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("name","你爹")
            editor.putInt("age",28)
            editor.putBoolean("married",false)
            editor.apply()
        }

        //读取数据
        val restoreBtn = findViewById<Button>(R.id.restoreButton)
        restoreBtn.setOnClickListener{
            val prefs = getSharedPreferences("data",Context.MODE_PRIVATE)
            val name = prefs.getString("name","")
            val age = prefs.getInt("age",0)
            val married = prefs.getBoolean("married",false)
            Log.d("SharedPreferencesTest","name is $name")
            Log.d("SharedPreferencesTest","age is $age")
            Log.d("SharedPreferencesTest","married is $married")
        }
    }
}