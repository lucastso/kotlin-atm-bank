package com.example.atm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.atm.data.model.LoginRequest
import com.example.atm.data.repository.AuthRepo
import com.example.atm.data.utils.SharedPreferences
import com.example.atm.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var loginViewModel: LoginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        sharedPreferences = SharedPreferences(this)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.btEntrar.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)

            if (binding.editTextTextEmailAddress.text.isEmpty()) {
                binding.editTextTextEmailAddress.error = "Verifique seu e-mail!"
            }

            if (binding.editTextTextPassword.text.isEmpty()) {
                binding.editTextTextPassword.error = "Verifique sua senha!"
            }

            val loginRequest = LoginRequest(
                email,
                password
            )

            loginViewModel.login(loginRequest)
            AuthRepo.successLogin.observe(this) {
                sharedPreferences.setUserId(it.id)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}