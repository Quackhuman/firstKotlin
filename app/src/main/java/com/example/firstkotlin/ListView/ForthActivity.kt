package com.example.firstkotlin.ListView

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.firstkotlin.R

class ForthActivity:AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()
//    ("鸡蛋", "香肠", "鸡", "鱼",
//        "虾", "猕猴桃", "柠檬", "葡萄", "牛油果", "西瓜",
//        "山竹", "肉", "菜", "胡萝卜", "西红柿", "香菇",
//        "青椒", "玉米", "葱姜蒜", "土豆")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forth_layout)
        val listView: ListView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,fruitList)
        listView.adapter = adapter
    }

}