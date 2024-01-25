package com.example.firstkotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.firstkotlin.Data.SharedPreferencesTest
import com.example.firstkotlin.Data.WritingData
import com.example.firstkotlin.BroadcastReceiver.BroadcastTest
import com.example.firstkotlin.Login.LoginActivity
import com.example.firstkotlin.RView.FifthActivity
import com.example.firstkotlin.ViewModel.ClickCounter
import com.example.firstkotlin.ViewModel.MainViewModel
import com.example.firstkotlin.ViewModel.VMLivingData.ClickCounterLD

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //按钮1的跳转设置
        val button1 : Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent("com.example.activitytest.ACTION_START")
            startActivityForResult(intent,1)
            Toast.makeText(this,"点击了button1按钮",Toast.LENGTH_SHORT).show()
        }

        //按钮2的跳转设置
        val button2 : Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent2 = Intent("android.intent.action.FORTH")
            startActivity(intent2)
            Toast.makeText(this,"点击了button1_2按钮",Toast.LENGTH_SHORT).show()
        }

        //按钮3的跳转设置
        val button3 : Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val intent3 = Intent(this,FifthActivity::class.java)
            startActivity(intent3)
            Toast.makeText(this,"点击了button1_3按钮",Toast.LENGTH_SHORT).show()
        }

        //按钮4的跳转设置
        val button4 : Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            val intent4 = Intent(this,ClickCounter::class.java)
            startActivity(intent4)
            Toast.makeText(this,"点击了button1_4 VM按钮",Toast.LENGTH_SHORT).show()
        }

        //按钮5的跳转设置
        val button5 : Button = findViewById(R.id.button5)
        button5.setOnClickListener {
            val intent5 = Intent(this,ClickCounterLD::class.java)
            startActivity(intent5)
            Toast.makeText(this,"点击了button1_5 VMLD按钮",Toast.LENGTH_SHORT).show()
        }

        //按钮5.5的跳转设置
        val button5_5 : Button = findViewById(R.id.button5_5)
        button5_5.setOnClickListener {
            val intent5_5 = Intent(this, BroadcastTest::class.java)
            startActivity(intent5_5)
            Toast.makeText(this,"点击了button7 Share Preferences",Toast.LENGTH_SHORT).show()
        }

        //按钮5.7的跳转设置
        val button5_7 : Button = findViewById(R.id.button5_7)
        button5_7.setOnClickListener {
            val intent5_7 = Intent(this, LoginActivity::class.java)
            startActivity(intent5_7)
            Toast.makeText(this,"点击了button 登录页",Toast.LENGTH_SHORT).show()
        }

        //按钮6的跳转设置
        val button6 : Button = findViewById(R.id.button6)
        button6.setOnClickListener {
            val intent6 = Intent(this,WritingData::class.java)
            startActivity(intent6)
            Toast.makeText(this,"点击了button6 Data",Toast.LENGTH_SHORT).show()
        }

        //按钮7的跳转设置
        val button7 : Button = findViewById(R.id.button7)
        button7.setOnClickListener {
            val intent7 = Intent(this,SharedPreferencesTest::class.java)
            startActivity(intent7)
            Toast.makeText(this,"点击了button7 Share Preferences",Toast.LENGTH_SHORT).show()
        }

        //viewModel的设置
        //不可以直接去创建ViewModel的实例，而是一定要通过ViewModelProvider来获取ViewModel的实例
        //ViewModelProvider(<你的Activity或Fragment实例>).get(<你的ViewModel>::class.java)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //声明按钮,设置按钮的响应
        val plusonebtn = findViewById<Button>(R.id.plusOneBtn)
        plusonebtn.setOnClickListener {
            viewModel.counter++
            //按按钮后执行动作，并把新值写入
            refreshCounter()
        }
        //写入完了之后就会按顺序再到这里执行，这次展示的值就是新值
        refreshCounter()

    }

    //给TextView赋值，一个方法
    private fun refreshCounter() {
        val infoText = findViewById<TextView>(R.id.infoText)
        infoText.text = viewModel.counter.toString()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 -> if(resultCode == RESULT_OK){
                val returnedData = data?.getStringExtra("data_return")
                Toast.makeText(this,returnedData,Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add",
                Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove",
                Toast.LENGTH_SHORT).show()
        }
        return true
    }

}
