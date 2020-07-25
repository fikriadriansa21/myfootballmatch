package com.example.myfootballmatch.ui.login.google

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.myfootballmatch.R
import com.example.myfootballmatch.ui.home.HomeActivity
import com.example.myfootballmatch.ui.home.HomeFragment
import com.example.myfootballmatch.ui.league.PickLeagueRegisterActivity
import com.example.myfootballmatch.utils.Utils
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_login_with_google.*
import kotlinx.android.synthetic.main.activity_login_with_google.et_email
import kotlinx.android.synthetic.main.activity_login_with_google.et_password
import kotlinx.android.synthetic.main.activity_register.*
import java.lang.Error

class LoginWithGoogleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_google)

        btn_login.setOnClickListener {
            Utils.makeSharedPreference(this)
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
