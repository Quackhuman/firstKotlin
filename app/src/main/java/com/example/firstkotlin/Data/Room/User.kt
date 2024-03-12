package com.example.firstkotlin.Data.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var firstName: String, var lastName: String, var age: Int) {

    //使用@PrimaryKey注解将它设为了主键，再把autoGenerate参数指定成true
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}