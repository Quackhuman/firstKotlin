package com.example.firstkotlin.ListView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.firstkotlin.R
import org.w3c.dom.Text

class FruitAdapter(activity: ForthActivity, val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //还是不知道有什么用，就当标准写法了
        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)

        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)

        //获取当前实例
        val fruit:Fruit? = getItem(position)
        if (fruit != null) {
            fruitImage.setImageResource(fruit.imageId)
            fruitName.text = fruit.name
        }
        return view
    }
}