package com.example.coba

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class mulaiDay3 : AppCompatActivity() {

    private lateinit var timerTextView3: TextView
    private lateinit var startButton3: Button
    private var countDownTimer: CountDownTimer? = null
    private var isTimerRunning = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulai_day3)

        timerTextView3 = findViewById(R.id.timerTextView3)
        startButton3 = findViewById(R.id.startButton3)

        startButton3.setOnClickListener {
            if (isTimerRunning) {
                // Stop the timer
                stopCountdown()
            } else {
                // Start the timer
                startCountdown(30000) // 30 detik
            }
        }
    }

    private fun startCountdown(timeInMillis: Long) {
        countDownTimer?.cancel() // Hentikan timer jika ada
        countDownTimer = object : CountDownTimer(timeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                timerTextView3.text = String.format("%02d:%02d", seconds / 60, seconds % 60)
            }

            override fun onFinish() {
                timerTextView3.text = "Time's Up!"
                isTimerRunning = false
                startButton3.text = "Start Timer" // Ubah teks tombol kembali
            }
        }.start()

        isTimerRunning = true
        startButton3.text = "Stop Timer" // Ubah teks tombol menjadi Stop
    }

    private fun stopCountdown() {
        countDownTimer?.cancel() // Hentikan timer
        isTimerRunning = false
        startButton3.text = "Start Timer" // Ubah teks tombol kembali
        timerTextView3.text = "00:00" // Reset timer
    }
}
