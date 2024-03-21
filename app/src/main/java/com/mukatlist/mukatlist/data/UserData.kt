package com.mukatlist.mukatlist.data

import com.mukatlist.mukatlist.MainActivity.Companion.prefs
import com.mukatlist.mukatlist.R

sealed class userData(
    var name: String? = prefs.getName(),
    var university: String? = prefs.getUniversity(),
    var profileImg: Int
){
    fun uploadProfileImg(){

    }

    fun getName_data(): String? {
        return name
    }

    fun getUniversity_data(): String?{
        return university
    }

    object user: userData(prefs.getName(), prefs.getUniversity(), R.drawable.nyangfoot1)
}



