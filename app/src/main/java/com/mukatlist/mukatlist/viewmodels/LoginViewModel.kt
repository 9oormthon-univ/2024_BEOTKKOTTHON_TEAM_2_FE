package com.mukatlist.mukatlist.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject internal constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {



}