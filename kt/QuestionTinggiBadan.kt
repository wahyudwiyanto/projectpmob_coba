package com.example.coba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuestionTinggiBadan : AppCompatActivity() {

    private lateinit var tvHeight: TextView
    private lateinit var tvUnit: TextView
    private lateinit var seekBarHeight: SeekBar
    private lateinit var radioGroupUnit: RadioGroup
    private lateinit var buttonNext: Button
    private var isCm = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questiontinggibadan)

        tvHeight = findViewById(R.id.tv_height)
        tvUnit = findViewById(R.id.tv_unit)
        seekBarHeight = findViewById(R.id.seekBarHeight)
        radioGroupUnit = findViewById(R.id.radioGroupUnit)
        buttonNext = findViewById(R.id.button_next)

        seekBarHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvHeight.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        radioGroupUnit.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio_cm -> {
                    isCm = true
                    tvUnit.text = "cm"
                    seekBarHeight.max = 250
                }
                R.id.radio_ft -> {
                    isCm = false
                    tvUnit.text = "ft"
                    seekBarHeight.max = 8
                }
            }
        }

        buttonNext.setOnClickListener {
        }
        val button_next = findViewById<Button>(R.id.button_next)

        button_next.setOnClickListener {
            val intent = Intent(this, beratBadan::class.java)
            startActivity(intent)
        }
    }

}
