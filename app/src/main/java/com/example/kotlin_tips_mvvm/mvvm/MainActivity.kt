package com.example.kotlin_tips_mvvm.mvvm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.viewModels
import com.example.kotlin_tips_mvvm.databinding.ActivityMainBinding
import com.example.kotlin_tips_mvvm.model.LoginState

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObserver()

        showKeyBoard(this, binding.edInput)
    }

    private fun initView() {
        binding.run {
            tvLogin.setOnClickListener {

                val inputText = edInput.text.toString()

                edInput.text.clear()
                tvState.text = ""

                loginViewModel.login(inputText)

                hideKeyBoard(this@MainActivity, binding.edInput)
            }
        }
    }

    private fun initObserver() {
        //監聽登入狀態
        loginViewModel.loginState.observe(this) { loginState ->
            when (loginState) {
                is LoginState.Success -> {
                    binding.tvState.text = "歡迎 ${loginState.account}"
                }
                is LoginState.Fail -> {
                    binding.tvState.text = "登入失敗"
                }
            }
        }
    }

    fun showKeyBoard(activity: AppCompatActivity, ed: EditText){
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(ed, 0)
    }

    fun hideKeyBoard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}