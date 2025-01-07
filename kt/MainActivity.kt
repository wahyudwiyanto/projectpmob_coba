package com.example.coba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isPasswordVisible: Boolean = false
    private lateinit var dbHelper: DatabaseHelper

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi DatabaseHelper
        dbHelper = DatabaseHelper(this)

        // Menghubungkan button dan EditText dari layout
        val button = findViewById<Button>(R.id.button12)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val showPasswordIcon = findViewById<ImageView>(R.id.showPasswordIcon)

        // Disable button login di awal
        button.isEnabled = false

        // Menambahkan TextWatcher untuk emailEditText
        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Enable button jika email tidak kosong
                button.isEnabled = !s.isNullOrEmpty()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        val button77 = findViewById<Button>(R.id.button77)

        button77.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        val button4 = findViewById<Button>(R.id.button4)

        button4.setOnClickListener {
            val intent = Intent(this, Jogging::class.java)
            startActivity(intent)
        }

        // Set click listener pada button
        button.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Cek login menggunakan database
            if (dbHelper.checkLogin(email, password)) {
                // Login berhasil, pindah ke gender activity
                val intent = Intent(this, gender::class.java)
                startActivity(intent)
                finish()
            } else {
                // Login gagal, tampilkan pesan error
                Toast.makeText(this, "Email atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }

        // Set click listener pada icon mata untuk show/hide password
        showPasswordIcon.setOnClickListener {
            if (isPasswordVisible) {
                // Jika password sedang terlihat, sembunyikan password
                passwordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
                showPasswordIcon.setImageResource(R.drawable.hide) // Ganti dengan ikon mata tertutup
            } else {
                // Jika password sedang tersembunyi, tampilkan password
                passwordEditText.transformationMethod = HideReturnsTransformationMethod.getInstance()
                showPasswordIcon.setImageResource(R.drawable.eye) // Ganti dengan ikon mata terbuka
            }
            isPasswordVisible = !isPasswordVisible
            // Pindahkan kursor ke akhir teks
            passwordEditText.setSelection(passwordEditText.text.length)
        }
    }
}
