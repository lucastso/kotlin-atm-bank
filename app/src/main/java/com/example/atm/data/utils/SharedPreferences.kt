package com.example.atm.data.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPreferences(context: Context) {
    private val LOGGED = "logged"
    private val pref: SharedPreferences = context.getSharedPreferences("SharedPreferences", 0)
    private val editor: SharedPreferences.Editor = pref.edit()

    fun setLogin(login: Boolean) {
        editor.putBoolean(LOGGED, login)
        editor.commit()
    }

    fun setBalance(balance: Int) {
        editor.putInt("balance", balance)
        editor.commit()
    }

    fun setEmail(email: String) {
        editor.putString("email", email)
        editor.commit()
    }

    fun setPassword(pwd: String) {
        editor.putString("password", pwd)
        editor.commit()
    }

    fun isLogin(): Boolean {
        return pref.getBoolean(LOGGED, false)
    }

    fun getEmail(): String? {
        return pref.getString("email", "")
    }

    fun getPassword(): String? {
        return pref.getString("password", "")
    }

    fun getBalance(): Int {
        return pref.getInt("balance", 0)
    }

    fun removeData() {
        editor.clear()
        editor.commit()
    }
}