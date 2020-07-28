package com.krayz.myfootballmatch.ui.success

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_success_registration.*


class SuccessRegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_registration)

        btn_jump_in.setOnClickListener {
            val  intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
