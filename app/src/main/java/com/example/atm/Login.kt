package com.example.atm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.atm.data.utils.SharedPreferences
import com.example.atm.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

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
            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)

            if (binding.editTextTextEmailAddress.text.isEmpty()) {
                binding.editTextTextEmailAddress.error = "Verifique seu e-mail!"
            }

            if (binding.editTextTextPassword.text.isEmpty()) {
                binding.editTextTextPassword.error = "Verifique sua senha!"
            }

            /*sharedPreferences.setEmail(binding.editTextTextEmailAddress.text.toString())
            sharedPreferences.setPassword(binding.editTextTextPassword.text.toString())
            sharedPreferences.setLogin(true)

            val uuid: UUID = UUID.randomUUID()
            val str: String = uuid.toString()*/

            if(binding.editTextTextPassword.text.isNotEmpty() && binding.editTextTextEmailAddress.text.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}