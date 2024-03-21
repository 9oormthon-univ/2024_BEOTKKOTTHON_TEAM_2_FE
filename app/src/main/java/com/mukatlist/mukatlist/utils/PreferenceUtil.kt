package com.mukatlist.mukatlist.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context){
    private val prefs: SharedPreferences =
        context.getSharedPreferences("prefs_userdata", Context.MODE_PRIVATE)

    fun setName(key: String = "Name", name: String){
        prefs.edit().putString(key, name).apply()
    }

    fun setUniversity(key: String = "University", university: String){
        prefs.edit().putString(key, university).apply()
    }

    fun getName(): String?{
        return prefs.getString("Name", "")
    }

    fun getUniversity(): String?{
        return prefs.getString("University", "")
    }

}