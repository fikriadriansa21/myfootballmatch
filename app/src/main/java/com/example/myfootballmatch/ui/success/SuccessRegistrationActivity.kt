package com.example.myfootballmatch.ui.success

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.myfootballmatch.R
import com.example.myfootballmatch.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_success_registration.*
import java.lang.Error


class SuccessRegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_registration)

        btn_jump_in.setOnClickListener {
//            val name = intent.getStringExtra("Home_Fragment")
//            val fragment = HomeFragment.newInstance(name)
            try {
                val fragment = HomeFragment()
                val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container, fragment)
                transaction.commit()
            }catch (error: Error){
                print(error)
            }
        }
    }
}
