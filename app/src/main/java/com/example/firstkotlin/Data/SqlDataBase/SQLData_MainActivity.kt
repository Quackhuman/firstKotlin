package com.example.firstkotlin.Data.SqlDataBase

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstkotlin.Data.Room.AppDatabase
import com.example.firstkotlin.Data.Room.User
import com.example.firstkotlin.R
import kotlin.concurrent.thread

class SQLData_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqldata_main)

        //绑定按钮
        val createDatabase = findViewById<Button>(R.id.createDatabase)

        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 2)
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }

        //绑定按钮
        val addData = findViewById<Button>(R.id.addData)
        addData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values1 = ContentValues().apply {
                //开始组装第一条数据
                put("name", "The Da Vinci Code")
                put("author", "John Johnson")
                put("pages", 454)
                put("price", 16.96)

            }
            //插入第一条数据
            db.insert("Book", null, values1)

            val values2 = ContentValues().apply {
                put("name", "The Lost Symbol")
                put("author", "Dan")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("Book", null, values2)
        }

        //将UserDao实例化
        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom","Clancy",40)
        val user2 = User("Tom","Hanks",47)

        //绑定按钮
        val addDataButton = findViewById<Button>(R.id.addDataBtn)
        addDataButton.setOnClickListener {
            thread {

            }
        }

    }
}


