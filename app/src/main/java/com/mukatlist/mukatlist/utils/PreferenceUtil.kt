package com.mukatlist.mukatlist.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreUserUpdate(val context : Context){
    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "dataStore")
    private val stringKey_name = stringPreferencesKey("name") // string 저장 키값
    private val stringKey_uni = stringPreferencesKey("university")

    // Flow : coroutines.flow import 해야됨
    val text_name : Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map {preferences ->
            preferences[stringKey_name] ?: ""
        }

    val text_uni : Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map {preferences ->
            preferences[stringKey_uni] ?: ""
        }

    // String값을 stringKey 키 값에 저장
    suspend fun setText_name(updateName : String){
        context.dataStore.edit { preferences ->
            preferences[stringKey_name] = updateName
        }
    }

    suspend fun setText_uni(updateUni : String){
        context.dataStore.edit { preferences ->
            preferences[stringKey_uni] = updateUni
        }
    }
}