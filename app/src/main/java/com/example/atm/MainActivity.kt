package com.example.atm

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.atm.data.model.TransactionRequest
import com.example.atm.data.repository.TransactionRepo
import com.example.atm.data.utils.SharedPreferences
import com.example.atm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var transactionViewModel: MainActivityViewModel = MainActivityViewModel()
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var recyclerView: RecyclerView
    private val transactions = mutableListOf<TransactionRequest>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        sharedPreferences = SharedPreferences(this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)
        recyclerView = binding.recyclerView

        binding.textSaldo.text = sharedPreferences.getBalance().toString()
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        transactionAdapter = TransactionAdapter(transactions)
        recyclerView.adapter = transactionAdapter

        binding.btRetirar.setOnClickListener {
            val quantity = binding.editTextQt.text.toString()
            if (quantity.isNotEmpty()) {
                if (binding.textSaldo.text.toString().toInt() >= quantity.toInt()) {
                    val transactionRequest = TransactionRequest(
                        1,
                        quantity.toInt()
                    )
                    transactionViewModel.postWithdraw(transactionRequest)
                    TransactionRepo.successWithdraw.observe(this) {
                        addTransaction(transactionRequest)

                        transactionViewModel.getBalance(1)
                    }
                } else {
                    binding.editTextQt.error = "Você não tem saldo!"
                    binding.textSaldo.setTextColor(Color.rgb(255, 0, 0))
                }
            } else {
                binding.editTextQt.error = "Digite um valor!"
            }
        }

        binding.btColocar.setOnClickListener {
            val quantity = binding.editTextQt.text.toString()
            if (quantity.isNotEmpty()) {
                val transactionRequest = TransactionRequest(
                    1,
                    quantity.toInt()
                )
                transactionViewModel.postDeposit(transactionRequest)
                TransactionRepo.successDeposit.observe(this) {
                    addTransaction(transactionRequest)

                    transactionViewModel.getBalance(1)
                }
            } else {
                binding.editTextQt.error = "Digite um valor!"
                binding.textSaldo.setTextColor(Color.rgb(255, 0, 0))
            }
        }

        binding.btSair.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun addTransaction(transaction: TransactionRequest) {
        transactions.add(transaction)
        transactionAdapter.notifyItemInserted(transactions.size - 1)
    }
}