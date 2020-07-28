package com.krayz.myfootballmatch.ui.profile

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.utils.Utils

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
