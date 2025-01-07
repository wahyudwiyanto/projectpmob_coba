//// MainActivity.kt
//package com.example.coba
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//
//class old : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_old)
//
//        val button3 = findViewById<Button>(R.id.button3)
//
//        button3.setOnClickListener {
//            val intent = Intent(this, QuestionPushUpMale::class.java)
//            startActivity(intent)
//        }
//    }
//}
// MainActivity.kt
package com.example.coba

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class old : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_old)

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, QuestionPushUpMale::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume called")
    }
}
