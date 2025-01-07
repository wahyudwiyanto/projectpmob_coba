package com.example.coba

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper // DatabaseHelper untuk SQLite

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inisialisasi DatabaseHelper
        dbHelper = DatabaseHelper(this)

        // Menghubungkan komponen layout
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditTextregis)
        val confirmPasswordEditText = findViewById<EditText>(R.id.passwordEditText)
        val registerButton = findViewById<Button>(R.id.button13)

        // Klik tombol register
        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Harap isi semua bidang!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Cek jika password dan konfirmasi password sama
            if (password != confirmPassword) {
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simpan data pengguna ke database
            val isInserted = dbHelper.addUser(username, password)
            if (isInserted) {
                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                finish() // Kembali ke activity sebelumnya (misalnya Login)
            } else {
                Toast.makeText(this, "Registrasi gagal!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
