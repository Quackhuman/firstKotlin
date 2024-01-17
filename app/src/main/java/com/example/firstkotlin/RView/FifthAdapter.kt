package com.example.firstkotlin.RView

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.firstkotlin.ListView.Fruit
import com.example.firstkotlin.R

class FifthAdapter:RecyclerView.Adapter<ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val imageView:ImageView = view.findViewById(R.id.fruitImage)
        private val textView:TextView = view.findViewById(R.id.fruitName)

        fun bindViewHolderItem(fruit: Fruit){
            imageView.setImageResource(fruit.imageId)
            textView.text = fruit.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}