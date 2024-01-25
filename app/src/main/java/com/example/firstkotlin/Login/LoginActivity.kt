package com.example.firstkotlin.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        val loginBtn = findViewById<Button>(R.id.login)
        val accountEdit = findViewById<EditText>(R.id.accountEdit)
        val passwordEdit = findViewById<EditText>(R.id.passwordEdit)
        loginBtn.setOnClickListener {
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            // 如果账号是Admin 且密码是123456，就认为登录成功
            if (account == "Admin" && password == "123456") {
                val intent = Intent(this,LoginMainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"wrongPassword",Toast.LENGTH_SHORT).show()
            }
        }


    }
}