package com.example.coba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class pengingat : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengingat)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        val noReminderRadio = findViewById<RadioButton>(R.id.noReminderRadio)
        val continueButton = findViewById<Button>(R.id.continueButton)
        // TimePicker Setup (24-hour format)
        timePicker.setIs24HourView(true)
        // SharedPreferences untuk menyimpan data
        val sharedPreferences = getSharedPreferences("ReminderData", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        continueButton.setOnClickListener {
            if (noReminderRadio.isChecked) {
                // Simpan status pengingat sebagai tidak diaktifkan
                editor.putBoolean("reminderEnabled", false)
                Toast.makeText(this, "Pengingat tidak diperlukan.", Toast.LENGTH_SHORT).show()
            } else {
                // Ambil waktu yang dipilih oleh pengguna
                val hour = timePicker.hour
                val minute = timePicker.minute
                // Simpan status dan waktu pengingat
                editor.putBoolean("reminderEnabled", true)
                editor.putInt("reminderHour", hour)
                editor.putInt("reminderMinute", minute)
                Toast.makeText(this, "Pengingat diatur pada: $hour:$minute", Toast.LENGTH_SHORT).show()
            }
            // Terapkan perubahan ke SharedPreferences
            editor.apply()
            // Pindah ke halaman utama
            val intent = Intent(this, halamanUtama::class.java)
            startActivity(intent)
            finish() // Tutup halaman ini agar tidak bisa kembali
        }
    }
    // Override onBackPressed untuk mencegah kembali ke halaman ini
    override fun onBackPressed() {
        super.onBackPressed()
        // Tutup aplikasi jika tombol back ditekan
        finishAffinity()
    }
}
