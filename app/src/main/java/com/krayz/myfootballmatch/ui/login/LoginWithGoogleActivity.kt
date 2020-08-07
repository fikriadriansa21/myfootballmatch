package com.krayz.myfootballmatch.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.ui.home.HomeActivity
import com.krayz.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.activity_login_with_google.*
import kotlinx.android.synthetic.main.activity_login_with_google.et_email
import kotlinx.android.synthetic.main.activity_login_with_google.et_password

class LoginWithGoogleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_google)
        Utils.makeSharedPreference(this)

        if (Utils.getSharedPrefereces(Utils.EMAIL) != ""){
            val  intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {

            val email = et_email.text.toString()
            val password = et_password.text.toString()

            if (email.isEmpty() && password.isEmpty()) {
                Toast.makeText(this, "Email atau password belum terisi !", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(email != Utils.getSharedPrefereces(Utils.EMAIL) && password != Utils.getSharedPrefereces(Utils.PASSWORD)){
                Toast.makeText(this, "Email atau password salah!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(email == Utils.getSharedPrefereces(Utils.EMAIL) && password == Utils.getSharedPrefereces(Utils.PASSWORD)){
                Toast.makeText(this,"Login berhasil!", Toast.LENGTH_SHORT).show()
                val  intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            }
        }
    }





}
