package com.example.firstkotlin.ListView

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firstkotlin.R

class ForthActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()
//    ("鸡蛋", "香肠", "香肠", "",
//        "虾", "猕猴桃", "柠檬", "葡萄", "牛油果", "西瓜",
//        "山竹", "肉", "菜", "胡萝卜", "西红柿", "香菇",
//        "青椒", "玉米", "葱姜蒜", "土豆")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forth_layout)
        initFruits()

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val fruitPosition = fruitList[position]
            Toast.makeText(this,fruitPosition.name,Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits() {
        fruitList.add(Fruit("鸡蛋", R.mipmap.jidan))
        fruitList.add(Fruit("香肠", R.mipmap.xiangchang))
        fruitList.add(Fruit("鱼", R.mipmap.yu))
        fruitList.add(Fruit("虾", R.mipmap.xia))
        fruitList.add(Fruit("猕猴桃", R.mipmap.mihoutao))
        fruitList.add(Fruit("柠檬", R.mipmap.ningmeng))
        fruitList.add(Fruit("葡萄", R.mipmap.putao))
        fruitList.add(Fruit("牛油果", R.mipmap.niuyouguo))
        fruitList.add(Fruit("西瓜", R.mipmap.xigua))
        fruitList.add(Fruit("山竹", R.mipmap.shanzhu))
        fruitList.add(Fruit("肉", R.mipmap.rou))
        fruitList.add(Fruit("菜", R.mipmap.cai))
        fruitList.add(Fruit("胡萝卜", R.mipmap.huluobo))
        fruitList.add(Fruit("西红柿", R.mipmap.xihongshi))
        fruitList.add(Fruit("香菇", R.mipmap.xianggu))
        fruitList.add(Fruit("青椒", R.mipmap.qingjiao))
        fruitList.add(Fruit("玉米", R.mipmap.yumi))
        fruitList.add(Fruit("葱姜蒜", R.mipmap.jiangcongsuan))
        fruitList.add(Fruit("土豆", R.mipmap.tudou))
    }
}