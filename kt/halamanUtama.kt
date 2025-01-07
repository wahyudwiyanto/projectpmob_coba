package com.example.coba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class halamanUtama : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cek versi Android sebelum memanggil enableEdgeToEdge
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            enableEdgeToEdge()
        }

        setContentView(R.layout.activity_halamanutama)

        // Pastikan R.id.main ada di layout activity_halamanutama.xml
        val mainView = findViewById<View>(R.id.main)
        mainView?.let {
            ViewCompat.setOnApplyWindowInsetsListener(it) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // Ambil data dari SharedPreferences
        val sharedPreferences = getSharedPreferences("ReminderData", MODE_PRIVATE)
        val reminderEnabled = sharedPreferences.getBoolean("reminderEnabled", false)

        val button15 = findViewById<Button>(R.id.button15)
        button15.setOnClickListener {
            val intent = Intent(this, inDay1::class.java)
            startActivity(intent)
        }

        val button16 = findViewById<Button>(R.id.button16)
        button16.setOnClickListener {
            val intent = Intent(this, inDay2::class.java)
            startActivity(intent)
        }

        val button17 = findViewById<Button>(R.id.button17)
        button17.setOnClickListener {
            val intent = Intent(this, inDay3::class.java)
            startActivity(intent)
        }

        val button14 = findViewById<Button>(R.id.button14)
        button14.setOnClickListener {
            val intent = Intent(this, inDay4::class.java)
            startActivity(intent)
        }

        val button18 = findViewById<Button>(R.id.button18)
        button18.setOnClickListener {
            val intent = Intent(this, inDay5::class.java)
            startActivity(intent)
        }

        val button199 = findViewById<Button>(R.id.button199)
        button199.setOnClickListener {
            val intent = Intent(this, inDay6::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            // Keluar dari aplikasi
            finishAffinity()
            return
        }


        // Tampilkan pesan peringatan
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Tekan kembali sekali lagi untuk keluar aplikasi", Toast.LENGTH_SHORT).show()

        // Reset status setelah 2 detik
        Handler(Looper.getMainLooper()).postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000)
    }
}
