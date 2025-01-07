package com.example.coba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class inDay4 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_in_day4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button37 = findViewById<Button>(R.id.button37)

        button37.setOnClickListener {
            val intent = Intent(this, mulaiDay1::class.java)
            startActivity(intent)
        }

        val button38 = findViewById<Button>(R.id.button38)

        button38.setOnClickListener {
            val intent = Intent(this, MulaiDay2::class.java)
            startActivity(intent)
        }

        val button39 = findViewById<Button>(R.id.button39)

        button39.setOnClickListener {
            val intent = Intent(this, mulaiDay3::class.java)
            startActivity(intent)
        }

        val button40 = findViewById<Button>(R.id.button40)

        button40.setOnClickListener {
            val intent = Intent(this, mulaiDay4::class.java)
            startActivity(intent)
        }

        val button41 = findViewById<Button>(R.id.button41)

        button41.setOnClickListener {
            val intent = Intent(this, mulaiDay5::class.java)
            startActivity(intent)
        }
    }
}