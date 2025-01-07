package com.example.coba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class inDay5 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_in_day5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button42 = findViewById<Button>(R.id.button42)

        button42.setOnClickListener {
            val intent = Intent(this, mulaiDay1::class.java)
            startActivity(intent)
        }

        val button43 = findViewById<Button>(R.id.button43)

        button43.setOnClickListener {
            val intent = Intent(this, MulaiDay2::class.java)
            startActivity(intent)
        }

        val button44 = findViewById<Button>(R.id.button44)

        button44.setOnClickListener {
            val intent = Intent(this, mulaiDay3::class.java)
            startActivity(intent)
        }

        val button45 = findViewById<Button>(R.id.button45)

        button45.setOnClickListener {
            val intent = Intent(this, mulaiDay4::class.java)
            startActivity(intent)
        }

        val button46 = findViewById<Button>(R.id.button46)

        button46.setOnClickListener {
            val intent = Intent(this, mulaiDay5::class.java)
            startActivity(intent)
        }
    }
}