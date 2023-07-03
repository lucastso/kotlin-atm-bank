package com.example.atm

import androidx.lifecycle.ViewModel
import com.example.atm.data.model.TransactionRequest
import com.example.atm.data.repository.TransactionRepo

class MainActivityViewModel: ViewModel() {
    fun postWithdraw(transactionRequest: TransactionRequest) {
        TransactionRepo.postWithdraw(transactionRequest)
    }

    fun postDeposit(transactionRequest: TransactionRequest) {
        TransactionRepo.postDeposit(transactionRequest)
    }

    fun getBalance(user_id: Int) {
        TransactionRepo.getBalance(user_id)
    }
}