package com.example.atm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.atm.data.utils.SharedPreferences
import com.example.atm.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        sharedPreferences = SharedPreferences(this)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.btEntrar.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.btRegistrar.setOnClickListener {
            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)

            if (binding.editTextTextEmailAddress.text.isEmpty()) {
                binding.editTextTextEmailAddress.error = "Verifique seu e-mail!"
            }

            if (binding.editTextTextPassword.text.isEmpty()) {
                binding.editTextTextPassword.error = "Verifique sua senha!"
            }

            if(binding.editTextTextPassword.text.isNotEmpty() && binding.editTextTextEmailAddress.text.isNotEmpty()) {
                sharedPreferences.setEmail(binding.editTextTextEmailAddress.text.toString())
                sharedPreferences.setPassword(binding.editTextTextPassword.text.toString())
                sharedPreferences.setLogin(true)
            }
        }
    }
}