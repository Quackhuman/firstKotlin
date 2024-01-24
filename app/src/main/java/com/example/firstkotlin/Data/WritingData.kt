package com.example.firstkotlin.Data

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firstkotlin.R
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class WritingData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_writing_data)
        val editText1 = findViewById<EditText>(R.id.editText)

        val inputText = load()
        if (inputText.isNotEmpty()){
            editText1.setText(inputText)
            // 将光标移动到最后
            editText1.setSelection(inputText.length)
            Toast.makeText(this,"读取数据成功",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val dataInput = findViewById<EditText>(R.id.editText)
        val inputText = dataInput.text.toString()
        save(inputText)
    }

    /**
    * 一个写入文件里的方法
    * */
    private fun save(inputText: String) {
        try {
            val output = openFileOutput("data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            // use函数，这是Kotlin提供的一个内置扩展函数。
            // 它会保证在Lambda表达式中的代码全部执行完之后自动将外层的流关闭，这样就不需要我们再编写一个finally语句，手动去关闭流了，是一个非常好用的扩展函数。
            writer.use {
                it.write(inputText)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * 一个读取文件里的方法
     * */
    private fun load():String {
        val content = StringBuilder()
        try {
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        }catch (e:IOException){
            e.printStackTrace()
        }
        return content.toString()
    }

}