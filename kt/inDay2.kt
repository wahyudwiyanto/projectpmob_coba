package com.example.coba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class inDay2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_in_day2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button27 = findViewById<Button>(R.id.button27)

        button27.setOnClickListener {
            val intent = Intent(this, mulaiDay1::class.java)
            startActivity(intent)
        }

        val button28 = findViewById<Button>(R.id.button28)

        button28.setOnClickListener {
            val intent = Intent(this, MulaiDay2::class.java)
            startActivity(intent)
        }

        val button29 = findViewById<Button>(R.id.button29)

        button29.setOnClickListener {
            val intent = Intent(this, mulaiDay3::class.java)
            startActivity(intent)
        }

        val button30 = findViewById<Button>(R.id.button30)

        button30.setOnClickListener {
            val intent = Intent(this, mulaiDay4::class.java)
            startActivity(intent)
        }

        val button31 = findViewById<Button>(R.id.button31)

        button31.setOnClickListener {
            val intent = Intent(this, mulaiDay5::class.java)
            startActivity(intent)
        }
    }
}