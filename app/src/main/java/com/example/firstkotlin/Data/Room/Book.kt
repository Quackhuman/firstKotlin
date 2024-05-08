package com.example.firstkotlin.Data.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(var name:String,var page:Int){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}