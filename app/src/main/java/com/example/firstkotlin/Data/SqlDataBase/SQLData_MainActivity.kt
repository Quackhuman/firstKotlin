package com.example.firstkotlin.Data.SqlDataBase

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstkotlin.R

class SQLData_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqldata_main)

        //绑定按钮
        val createDatabase = findViewById<Button>(R.id.createDatabase)

        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 1)
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }
    }
}


