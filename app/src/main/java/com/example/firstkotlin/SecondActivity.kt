package com.example.firstkotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val data = "你好，页面3"
            val intent = Intent(this,ThirdActivity::class.java)
            intent.putExtra("extra_data",data)
            startActivity(intent)
        }
    }
}