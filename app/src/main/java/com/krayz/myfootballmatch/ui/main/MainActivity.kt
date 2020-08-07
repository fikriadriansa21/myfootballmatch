package com.krayz.myfootballmatch.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.ui.login.LoginWithGoogleActivity
import com.krayz.myfootballmatch.ui.register.RegisterActivity
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
