package com.example.myfootballmatch.utils

import android.app.Activity
import android.content.SharedPreferences

object Utils {

    var sharedPreferences : SharedPreferences? = null

    const val NAMA = "NAMA"
    const val EMAIL = "EMAIL"
    const val PASSWORD = "PASSWORD"
    const val USERNAME = "USERNAME"


    fun makeSharedPreference(activity: Activity){
        sharedPreferences = activity.getSharedPreferences("USER_PREF", 0)
    }

    fun putSharedPrferences(key : String,data : String){
        val editor = sharedPreferences!!.edit()
        editor.putString(key, data)
        editor.apply()
    }

    fun putFavoriteSharedPreference(key : String,data : HashSet<String>){
        val editor = sharedPreferences!!.edit()
        editor.putStringSet(key, data)
        editor.apply()
    }

    fun getFavoriteSharedPrefereces(key:String) : HashSet<String>{
        val o = sharedPreferences!!.getStringSet(key,HashSet<String>())!!
        return  o as HashSet<String>
    }

    fun putSharedPrferences(key : String,data : Int){
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