package com.example.kotlin_tips_mvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_tips_mvvm.model.LoginRepository
import com.example.kotlin_tips_mvvm.model.LoginState

class LoginViewModel: ViewModel() {

    private val loginRepository = LoginRepository()

    //LiveData
    private val _loginState = MutableLiveData<LoginState>()
    val loginState: LiveData<LoginState> get() = _loginState


    fun login(account: String) {
        _loginState.value = loginRepository.login(account)
    }
}