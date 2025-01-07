// MainActivity.kt
package com.example.coba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class goalfitnes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tujuan)


        val button7 = findViewById<Button>(R.id.button7)

        button7.setOnClickListener {
            val intent = Intent(this, old::class.java)
            startActivity(intent)
        }

        val button11 = findViewById<Button>(R.id.button11)
        button11.setOnClickListener {

            val intent = Intent(this, old::class.java)
            startActivity(intent)
        }

    }
}

