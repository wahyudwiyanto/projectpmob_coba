package com.example.coba

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class mulaiDay4 : AppCompatActivity() {

    private lateinit var timerTextView4: TextView
    private lateinit var startButton4: Button
    private var countDownTimer: CountDownTimer? = null
    private var isTimerRunning = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulai_day4)

        timerTextView4 = findViewById(R.id.timerTextView4)
        startButton4 = findViewById(R.id.startButton4)

        startButton4.setOnClickListener {
            if (isTimerRunning) {
                // Stop the timer
                stopCountdown()
            } else {
                // Start the timer
                startCountdown(20000) // 20 detik
            }
        }
    }

    private fun startCountdown(timeInMillis: Long) {
        countDownTimer?.cancel() // Hentikan timer jika ada
        countDownTimer = object : CountDownTimer(timeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                timerTextView4.text = String.format("%02d:%02d", seconds / 60, seconds % 60)
            }

            override fun onFinish() {
                timerTextView4.text = "Time's Up!"
                isTimerRunning = false
                startButton4.text = "Start Timer" // Ubah teks tombol kembali
            }
        }.start()

        isTimerRunning = true
        startButton4.text = "Stop Timer" // Ubah teks tombol menjadi Stop
    }

    private fun stopCountdown() {
        countDownTimer?.cancel() // Hentikan timer
        isTimerRunning = false
        startButton4.text = "Start Timer" // Ubah teks tombol kembali
        timerTextView4.text = "00:00" // Reset timer
    }
}
