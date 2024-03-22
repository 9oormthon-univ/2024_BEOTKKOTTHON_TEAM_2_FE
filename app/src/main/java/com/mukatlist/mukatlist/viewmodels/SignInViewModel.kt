package com.mukatlist.mukatlist.viewmodels

import androidx.lifecycle.ViewModel
import com.mukatlist.mukatlist.data.userdata
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(userdata(name = ""))
    val uiState: StateFlow<userdata> = _uiState.asStateFlow()


    fun setName(Name: String) {
        _uiState.update { currentState ->
            currentState.copy(name = Name)
        }
    }

    fun setUni(Uni: String) {
        _uiState.update { currentState ->
            currentState.copy(university = Uni)
        }
    }

    fun getName(): String{
        return uiState.value.name
    }

    fun getUni(): String{
        return uiState.value.university
    }
}