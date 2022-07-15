package com.example.kotlin_tips_mvvm.model

class LoginRepository {

    fun login (account: String): LoginState {
        return  if (account.contains("123")) {
            LoginState.Success(account)
        } else {
            LoginState.Fail
        }
    }
}