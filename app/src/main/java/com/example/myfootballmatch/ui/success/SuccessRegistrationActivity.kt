package com.example.myfootballmatch.ui.success

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfootballmatch.R
import com.example.myfootballmatch.ui.home.HomeActivity
import com.example.myfootballmatch.ui.home.HomeFragment
import com.example.myfootballmatch.ui.login.google.LoginWithGoogleActivity
import com.example.myfootballmatch.ui.team.register.TeamRegisterActivity
import kotlinx.android.synthetic.main.activity_success_registration.*

class SuccessRegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_registration)

        btn_jump_in.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
