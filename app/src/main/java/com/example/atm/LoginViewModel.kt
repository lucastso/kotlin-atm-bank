package com.example.atm

import androidx.lifecycle.ViewModel
import com.example.atm.data.model.LoginRequest
import com.example.atm.data.model.RegisterRequest
import com.example.atm.data.repository.AuthRepo

class LoginViewModel: ViewModel() {
    fun login(loginRequest: LoginRequest) {
        AuthRepo.login(loginRequest)
    }

    fun register(registerRequest: RegisterRequest) {
        AuthRepo.register(registerRequest)
    }
}