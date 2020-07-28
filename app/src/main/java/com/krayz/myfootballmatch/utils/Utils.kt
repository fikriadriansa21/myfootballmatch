package com.krayz.myfootballmatch.utils

import android.app.Activity
import android.content.SharedPreferences

object Utils {
    var sharedPreferences : SharedPreferences? = null
    const val NAMA = "NAMA"
    const val EMAIL = "EMAIL"
    const val PASSWORD = "PASSWORD"
    const val USERNAME = "USERNAME"
    const val LEAGUE_ID = "LEAGUE_ID"
    const val LEAGUE_NAME = "LEAGUE_NAME"
    const val TEAM_ID = "TEAM_ID"
    const val TEAM_ID_FAV = "TEAM_ID_FAV"
    const val TEAM_NAME = "TEAM_NAME"

    fun makeSharedPreference(activity: Activity){
        sharedPreferences = activity.getSharedPreferences("USER_PREF", 0)
    }

    fun putSharedPreferences(key : String,data : String){
        val editor = sharedPreferences!!.edit()
        editor.putString(key, data)
        editor.apply()
    }

    fun putSharedPreferences(key : String,data : Int){
        val editor = sharedPreferences!!.edit()
        editor.putInt(key, data)
        editor.apply()
    }

    fun getSharedPrefereces(key:String) : String{
        return sharedPreferences!!.getString(key,"")!!
    }

    fun getIntSharedPrefereces(key:String) : Int{
        return sharedPreferences!!.getInt(key,0)
    }
}