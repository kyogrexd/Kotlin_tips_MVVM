package com.example.kotlin_tips_mvvm.model

sealed class LoginState {
    class Success(val account: String): LoginState()
    object Fail: LoginState()
}