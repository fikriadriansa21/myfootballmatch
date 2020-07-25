package com.example.myfootballmatch.ui.profile

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.myfootballmatch.R
import com.example.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Utils.makeSharedPreference(this.context as Activity)
        val textName = Utils.getSharedPrefereces(Utils.NAMA)
//        tv_name_user.text = textName
//
//        val textUsername = Utils.getSharedPrefereces(Utils.USERNAME)
//        tv_username.text = textUsername
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

}
