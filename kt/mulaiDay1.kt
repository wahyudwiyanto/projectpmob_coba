package com.example.coba

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class mulaiDay1 : AppCompatActivity() {

    private lateinit var timerTextView: TextView
    private lateinit var startButton: Button
    private var countDownTimer: CountDownTimer? = null
    private var isTimerRunning = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulai_day1)

        timerTextView = findViewById(R.id.timerTextView)
        startButton = findViewById(R.id.startButton)

        startButton.setOnClickListener {
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
                timerTextView.text = String.format("%02d:%02d", seconds / 60, seconds % 60)
            }

            override fun onFinish() {
                timerTextView.text = "Time's Up!"
                isTimerRunning = false
                startButton.text = "Start Timer" // Ubah teks tombol kembali
            }
        }.start()

        isTimerRunning = true
        startButton.text = "Stop Timer" // Ubah teks tombol menjadi Stop
    }

    private fun stopCountdown() {
        countDownTimer?.cancel() // Hentikan timer
        isTimerRunning = false
        startButton.text = "Start Timer" // Ubah teks tombol kembali
        timerTextView.text = "00:00" // Reset timer
    }
}
