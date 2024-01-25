package com.example.firstkotlin.Login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstkotlin.MainActivity
import com.example.firstkotlin.R

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //声明那些控件
        val loginBtn = findViewById<Button>(R.id.login)
        val accountEdit = findViewById<EditText>(R.id.accountEdit)
        val passwordEdit = findViewById<EditText>(R.id.passwordEdit)
        val cbRememberPass = findViewById<CheckBox>(R.id.rememberPass)

        val prefs = getPreferences(Context.MODE_PRIVATE)

        val isRemember = prefs.getBoolean("remember_password",false)
        if(isRemember){
            //将账号密码设置到文本框中
            val account = prefs.getString("account","")
            val password = prefs.getString("password","")
            accountEdit.setText(account)
            passwordEdit.setText(password)
            //设置选项为勾选
            cbRememberPass.isChecked = true
        }

        //登录的功能
        loginBtn.setOnClickListener {

            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()

            // 如果账号是Admin 且密码是123456，就认为登录成功
            if (account == "Admin" && password == "123456") {

                val editor = prefs.edit()

                if(cbRememberPass.isChecked){
                    editor.putBoolean("remember_password",true)
                    editor.putString("account",account)
                    editor.putString("password",password)
                }else{
                    editor.clear()
                }
                //提交内容进行保存
                editor.apply()

                //设置登录后的跳转
                val intent = Intent(this,LoginMainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"wrongPassword",Toast.LENGTH_SHORT).show()
            }
        }


    }
}