package com.example.coba

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class beratBadan : AppCompatActivity() {

    private var isKgSelected: Boolean = true
    private var weight: Float = 65.5f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beratbadan)

        val button5 = findViewById<Button>(R.id.button5)

        button5.setOnClickListener {
            val intent = Intent(this, pengingat::class.java)
            startActivity(intent)
        }

        val weightSeekBar = findViewById<SeekBar>(R.id.weightSeekBar)
        val weightTextView = findViewById<TextView>(R.id.weightTextView)
        val bmiTextView = findViewById<TextView>(R.id.bmiTextView)
        val kgButton = findViewById<RadioButton>(R.id.kgButton)
        val lbButton = findViewById<RadioButton>(R.id.lbButton)

        // Update berat badan berdasarkan SeekBar
        weightSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                weight = progress.toFloat()
                updateWeightText(weight, isKgSelected)
                calculateAndDisplayBMI(weight, isKgSelected, bmiTextView)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Update jika satuan berat diubah
        kgButton.setOnCheckedChangeListener { _, isChecked ->
            isKgSelected = isChecked
            updateWeightText(weight, isKgSelected)
            calculateAndDisplayBMI(weight, isKgSelected, bmiTextView)
        }

        lbButton.setOnCheckedChangeListener { _, isChecked ->
            isKgSelected = !isChecked
            updateWeightText(weight, isKgSelected)
            calculateAndDisplayBMI(weight, isKgSelected, bmiTextView)
        }
    }

    private fun updateWeightText(weight: Float, isKg: Boolean) {
        val weightTextView = findViewById<TextView>(R.id.weightTextView)
        val unit = if (isKg) "kg" else "lb"
        weightTextView.text = "$weight $unit"
    }

    private fun calculateAndDisplayBMI(weight: Float, isKg: Boolean, bmiTextView: TextView) {
        val weightInKg = if (isKg) weight else weight * 0.453592f
        val heightInMeters = 1.65f // Misalkan tinggi badan default 1.65m

        val bmi = weightInKg / heightInMeters.pow(2)

        bmiTextView.text = String.format("BMI: %.1f", bmi)
    }
}
