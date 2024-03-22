package com.mukatlist.mukatlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mukatlist.mukatlist.utils.MukatlistApp

class HomeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            MukatlistApp()
        }
    }

}