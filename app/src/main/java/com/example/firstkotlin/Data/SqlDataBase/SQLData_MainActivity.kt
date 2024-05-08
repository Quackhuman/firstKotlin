package com.example.firstkotlin.Data.SqlDataBase

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstkotlin.Data.Room.AppDatabase
import com.example.firstkotlin.Data.Room.User
import com.example.firstkotlin.R
import kotlin.concurrent.thread
import kotlin.math.log

class SQLData_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqldata_main)

        //绑定按钮createDatabase
        val createDatabase = findViewById<Button>(R.id.createDatabase)

        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 2)
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }

        //绑定按钮addData
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
        //通过上面的User方法（类），设置了两个user的内容
        val user1 = User("Tom","Clancy",40)
        val user2 = User("Tom","Hanks",67)

        //绑定按钮addDataButton
        val addDataButton = findViewById<Button>(R.id.addDataBtn)
        addDataButton.setOnClickListener {
            thread {
                //这的id是省去了setter的id，后面的返回值给它设置
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }

        //绑定按钮upDateBtn
        val upDateBtn = findViewById<Button>(R.id.updateDataBtn)
        upDateBtn.setOnClickListener {
            thread {
                //设置user1的age为45
                user1.age = 45
                //执行一次更新任务
                userDao.updateUser(user1)
            }
        }

        //绑定按钮deleteDataBtn
        val deleteDataBtn = findViewById<Button>(R.id.deleteDataBtn)
        deleteDataBtn.setOnClickListener {
            thread {
                //这里就是直接执行一个方法就行，通过lastname删一个数据
                userDao.deleteUserByLastName("Hanks")
            }
        }

        //绑定查询按钮
        val queryDataBtn = findViewById<Button>(R.id.queryDataBtn)
        queryDataBtn.setOnClickListener {
            thread {
                //这个遍历很难我看不懂
                for(user in userDao.loadAllUsers()){
                    Log.d("SQLData_MainActivity",user.toString())
                }
            }
        }

    }
}


