package com.example.coba

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class inDay6 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_in_day6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button47 = findViewById<Button>(R.id.button47)

        button47.setOnClickListener {
            val intent = Intent(this, mulaiDay1::class.java)
            startActivity(intent)
        }

        val button48 = findViewById<Button>(R.id.button48)

        button48.setOnClickListener {
            val intent = Intent(this, MulaiDay2::class.java)
            startActivity(intent)
        }

        val button49 = findViewById<Button>(R.id.button49)

        button49.setOnClickListener {
            val intent = Intent(this, mulaiDay3::class.java)
            startActivity(intent)
        }

        val button50 = findViewById<Button>(R.id.button50)

        button50.setOnClickListener {
            val intent = Intent(this, mulaiDay4::class.java)
            startActivity(intent)
        }

        val button51 = findViewById<Button>(R.id.button51)

        button51.setOnClickListener {
            val intent = Intent(this, mulaiDay5::class.java)
            startActivity(intent)
        }
    }
}