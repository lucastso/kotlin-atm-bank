package com.example.atm

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.view.inputmethod.InputMethodManager
import com.example.atm.data.model.User
import com.example.atm.data.utils.SharedPreferences
import com.example.atm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        sharedPreferences = SharedPreferences(this)
        setContentView(binding.root)
    }

    @SuppressLint("ServiceCast")
    override fun onStart() {
        super.onStart()

        binding.textSaldo.text = sharedPreferences.getBalance().toString()

        binding.btRetirar.setOnClickListener {
            if (binding.editTextQt.text.isNotEmpty()) {
                if(binding.textSaldo.text.toString().toInt() >= binding.editTextQt.text.toString().toInt()) {
                    sharedPreferences.setBalance(sharedPreferences.getBalance()!! - binding.editTextQt.text.toString().toInt())
                    binding.textSaldo.text = sharedPreferences.getBalance().toString()
                    binding.editTextQt.setText("")
                    val inputMethodManager =
                        getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
                } else {
                    binding.editTextQt.error = "Você não tem saldo"
                    binding.textSaldo.setTextColor(Color.rgb(255, 0, 0))
                }
            } else {
                binding.editTextQt.error = "Digite um valor!"
            }
        }

        binding.btColocar.setOnClickListener {
            if(sharedPreferences.getBalance()!! < 25000) {
                sharedPreferences.setBalance(sharedPreferences.getBalance()!! + 1000)
                binding.textSaldo.text = sharedPreferences.getBalance().toString()
                binding.textSaldo.setTextColor(Color.rgb(0, 0, 0))
                binding.editTextQt.error = null
            }
        }
    }
}