package com.example.atm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.atm.data.model.TransferRequest
import com.example.atm.data.repository.TransactionRepo
import com.example.atm.data.utils.SharedPreferences
import com.example.atm.databinding.ActivityMainBinding
import com.example.atm.databinding.ActivityTransferBinding

class TransferActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransferBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var transactionViewModel: MainActivityViewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityTransferBinding.inflate(layoutInflater)
        sharedPreferences = SharedPreferences(this)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        val qt = binding.editTextQt.text.toString()
        val who = binding.editTextWho.text.toString()

        val transferRequest = TransferRequest(
            sharedPreferences.getUserId(),
            who.toInt(),
            qt.toInt()
        )

        transactionViewModel.postTransfer(transferRequest)
        TransactionRepo.successTransfer.observe(this) {
            Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
        }
    }
}