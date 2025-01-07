// MainActivity.kt
package com.example.coba

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)

        val button10 = findViewById<Button>(R.id.button10)

        button10.setOnClickListener {
            // Simpan status login pengguna
            val editor = sharedPreferences.edit()
            editor.putBoolean("is_logged_in", true)
            editor.apply()

            // Arahkan ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup Login Activity setelah berhasil login
        }

        val button9 = findViewById<Button>(R.id.button9)

        button9.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        if (isUserLoggedIn()) {
            // Jika pengguna sudah login, langsung pindah ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup Login Activity agar tidak bisa kembali
        }
    }
    override fun onStop() {
        super.onStop()
        if (isUserLoggedIn()) {
            finish()
        }
    }

    private fun isUserLoggedIn(): Boolean {
        return sharedPreferences.getBoolean("is_logged_in", false)
    }
}
