package com.mukatlist.mukatlist

import android.app.Application
import com.google.firebase.FirebaseApp
import com.mukatlist.mukatlist.utils.DataStoreUserUpdate

class MainApplication : Application(){
    private lateinit var dataStore : DataStoreUserUpdate

    companion object {
        private lateinit var prefs : MainApplication
        fun getInstance() : MainApplication = prefs
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        prefs = this
        dataStore = DataStoreUserUpdate(this)
    }

    fun getDataStore(): DataStoreUserUpdate = dataStore
}