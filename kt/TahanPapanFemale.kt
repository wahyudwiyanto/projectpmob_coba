// MainActivity.kt
package com.example.coba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TahanPapanFemale : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tahanpapanfemale)

        val button21 = findViewById<Button>(R.id.button21)
        button21.setOnClickListener {
            val intent = Intent(this, QuestionTinggiBadan::class.java)
            startActivity(intent)
        }
        val button22 = findViewById<Button>(R.id.button22)
        button22.setOnClickListener {
            val intent = Intent(this, QuestionTinggiBadan::class.java)
            startActivity(intent)
        }
        val button23 = findViewById<Button>(R.id.button23)
        button23.setOnClickListener {
            val intent = Intent(this, QuestionTinggiBadan::class.java)
            startActivity(intent)
        }
        val button24 = findViewById<Button>(R.id.button24)
        button24.setOnClickListener {
            val intent = Intent(this, QuestionTinggiBadan::class.java)
            startActivity(intent)
        }
        val button25 = findViewById<Button>(R.id.button25)
        button25.setOnClickListener {
            val intent = Intent(this, QuestionTinggiBadan::class.java)
            startActivity(intent)
        }

    }
}

