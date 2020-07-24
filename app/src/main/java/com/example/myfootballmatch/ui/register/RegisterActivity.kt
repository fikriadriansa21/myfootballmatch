package com.example.myfootballmatch.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myfootballmatch.R
import com.example.myfootballmatch.ui.home.HomeActivity
import com.example.myfootballmatch.ui.league.PickLeagueRegisterActivity
import com.example.myfootballmatch.ui.main.MainActivity
import com.example.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_continue.setOnClickListener {
            Utils.makeSharedPreference(this)
            Utils.putSharedPreferences(Utils.NAMA,et_name.text.toString())
            Utils.putSharedPreferences(Utils.EMAIL,et_email.text.toString())
            Utils.putSharedPreferences(Utils.USERNAME,et_username.text.toString())
            Utils.putSharedPreferences(Utils.PASSWORD,et_password.text.toString())

            if (et_name.length() == 0|| et_email.length() == 0|| et_username.length() == 0 ||et_password.length() == 0){
                Toast.makeText(this, "There is empty filled!",Toast.LENGTH_SHORT).show()

            }
            if (et_name.length() > 1 || et_email.length() > 1|| et_username.length() > 1 ||et_password.length() > 1){
                val intent = Intent(this, PickLeagueRegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
