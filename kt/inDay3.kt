package com.example.coba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class inDay3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_in_day3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R. id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button32 = findViewById<Button>(R.id.button32)

        button32.setOnClickListener {
            val intent = Intent(this, mulaiDay1::class.java)
            startActivity(intent)
        }

        val button33 = findViewById<Button>(R.id.button33)

        button33.setOnClickListener {
            val intent = Intent(this, MulaiDay2::class.java)
            startActivity(intent)
        }

        val button34 = findViewById<Button>(R.id.button34)

        button34.setOnClickListener {
            val intent = Intent(this, mulaiDay3::class.java)
            startActivity(intent)
        }

        val button35 = findViewById<Button>(R.id.button35)

        button35.setOnClickListener {
            val intent = Intent(this, mulaiDay4::class.java)
            startActivity(intent)
        }

        val button36 = findViewById<Button>(R.id.button36)

        button36.setOnClickListener {
            val intent = Intent(this, mulaiDay5::class.java)
            startActivity(intent)
        }
    }
}