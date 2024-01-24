package com.example.firstkotlin.Data

import android.content.Context
import android.os.Bundle
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

        val saveBtn = findViewById<Button>(R.id.saveButton)
        saveBtn.setOnClickListener{
            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("name","你爹")
            editor.putInt("age",28)
            editor.putBoolean("married",false)
            editor.apply()
        }


    }
}