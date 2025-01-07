package com.example.coba

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Menggunakan Handler untuk menunda selama 3 detik
        Handler(Looper.getMainLooper()).postDelayed({
            // Setelah delay, arahkan ke Login Activity
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish() // Menutup splash agar tidak dapat kembali
        }, 3000) // 3000 ms = 3 detik
    }
}
