package com.example.atm.data.utils

import android.content.Context
import com.example.atm.data.model.User

class SharedPreferences(context: Context) {
    private val pref = context.getSharedPreferences("SharedPreferences", 0)
    private val editor = pref.edit()

    fun setBalance(bal: Int) {
        editor.putInt("balance", bal)
        editor.commit()
    }

    fun getBalance(): Int? {
        return pref.getInt("balance", 0)
    }
}