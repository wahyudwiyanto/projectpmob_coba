// MainActivity.kt
package com.example.coba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class gender : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gender)

        val button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            val intent = Intent(this, goalfitnes::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener {
            val intent = Intent(this, goalfitnes::class.java)
            startActivity(intent)
        }
    }
}

