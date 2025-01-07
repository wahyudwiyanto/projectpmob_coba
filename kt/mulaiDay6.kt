package com.example.coba

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class mulaiDay6 : AppCompatActivity() {

    private lateinit var timerTextView699: TextView
    private lateinit var startButton699: Button
    private var countDownTimer: CountDownTimer? = null
    private var isTimerRunning = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulai_day6)

        timerTextView699 = findViewById(R.id.timerTextView699)
        startButton699 = findViewById(R.id.startButton699)

        startButton699.setOnClickListener {
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
                timerTextView699.text = String.format("%02d:%02d", seconds / 60, seconds % 60)
            }

            override fun onFinish() {
                timerTextView699.text = "Time's Up!"
                isTimerRunning = false
                startButton699.text = "Start Timer" // Ubah teks tombol kembali
            }
        }.start()

        isTimerRunning = true
        startButton699.text = "Stop Timer" // Ubah teks tombol menjadi Stop
    }

    private fun stopCountdown() {
        countDownTimer?.cancel() // Hentikan timer
        isTimerRunning = false
        startButton699.text = "Start Timer" // Ubah teks tombol kembali
        timerTextView699.text = "00:00" // Reset timer
    }
}
