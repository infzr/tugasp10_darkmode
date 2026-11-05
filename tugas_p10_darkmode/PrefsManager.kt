package com.example.tugas_p10_darkmode

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)

    fun setDarkMode(isDark: Boolean) {
        prefs.edit().putBoolean("DARK_MODE", isDark).apply()
    }

    fun isDarkMode(): Boolean {
        return prefs.getBoolean("DARK_MODE", false)
    }
}