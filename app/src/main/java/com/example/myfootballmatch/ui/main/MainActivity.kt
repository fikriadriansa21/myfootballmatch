package com.example.myfootballmatch.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfootballmatch.R
import com.example.myfootballmatch.ui.login.google.LoginWithGoogleActivity
import com.example.myfootballmatch.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get_started.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        tv_login.setOnClickListener {
            val intent = Intent(this, LoginWithGoogleActivity::class.java)
            startActivity(intent)
        }
    }
}
