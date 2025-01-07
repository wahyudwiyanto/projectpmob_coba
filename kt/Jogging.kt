package com.example.coba

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Jogging : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var joggingInfoText: TextView
    private lateinit var startStopButton: Button
    private lateinit var finishButton: Button
    private lateinit var historyButton: Button
    private lateinit var databaseHelper: JoggingDatabaseHelper

    private var isJogging = false
    private var joggingTimeInSeconds = 0
    private val handler = Handler(Looper.getMainLooper())
    private val updateTimeRunnable = object : Runnable {
        override fun run() {
            if (isJogging) {
                joggingTimeInSeconds++
                updateJoggingInfo()
                handler.postDelayed(this, 1000) // Perbarui setiap detik
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogging)

        // Inisialisasi elemen UI
        joggingInfoText = findViewById(R.id.joggingInfoText)
        startStopButton = findViewById(R.id.startStopButton)
        finishButton = findViewById(R.id.selesai)
        historyButton = findViewById(R.id.viewDataButton)

        // Inisialisasi database helper
        databaseHelper = JoggingDatabaseHelper(this)

        // Inisialisasi peta
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Atur tombol start/stop jogging
        startStopButton.setOnClickListener {
            toggleJogging()
        }

        // Atur tombol finish jogging
        finishButton.setOnClickListener {
            finishJogging()
        }

        // Atur tombol History
        historyButton.setOnClickListener {
            // Intent untuk membuka JoggingHistoryActivity
            val intent = Intent(this, JoggingHistoryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showJoggingHistory() {
        val joggingHistory = databaseHelper.getAllJoggingData()
        if (joggingHistory.isNotEmpty()) {
            // Menampilkan riwayat jogging dalam bentuk Toast atau TextView
            val historyText = joggingHistory.joinToString("\n")
            Toast.makeText(this, "Jogging History:\n$historyText", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "No jogging history found", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        // Simpan instance peta
        map = googleMap

        // Lokasi default (misalnya Jakarta)
        val defaultLocation = LatLng(-6.2088, 106.8456)

        // Tambahkan marker di lokasi default
        map.addMarker(MarkerOptions().position(defaultLocation).title("Marker in Jakarta"))

        // Atur kamera ke lokasi default dengan zoom level 15
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 15f))

        // Opsional: Aktifkan lokasi pengguna jika izin diberikan
        enableMyLocation()
    }

    private fun enableMyLocation() {
        if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            map.isMyLocationEnabled = true
        } else {
            requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
        }
    }

    private fun toggleJogging() {
        if (isJogging) {
            stopJogging()
        } else {
            startJogging()
        }
    }

    private fun startJogging() {
        isJogging = true
        startStopButton.text = "Pause"
        handler.post(updateTimeRunnable)
    }

    private fun stopJogging() {
        isJogging = false
        startStopButton.text = "Start Jogging"
        handler.removeCallbacks(updateTimeRunnable)
    }

    private fun finishJogging() {
        stopJogging()
        val minutes = joggingTimeInSeconds / 60
        val seconds = joggingTimeInSeconds % 60
        val summary = "Jogging selesai! Total waktu: $minutes menit $seconds detik"
        joggingInfoText.text = summary

        // Simpan data ke database
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val durationInMinutes = joggingTimeInSeconds / 60
        val result = databaseHelper.insertJoggingData(date, durationInMinutes)

        if (result != -1L) {
            Toast.makeText(this, "Data saved: $date, $durationInMinutes minutes", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Failed to save data!", Toast.LENGTH_SHORT).show()
        }

        // Reset waktu jogging
        joggingTimeInSeconds = 0
    }

    private fun updateJoggingInfo() {
        val minutes = joggingTimeInSeconds / 60
        val seconds = joggingTimeInSeconds % 60
        joggingInfoText.text = String.format("Jogging Time: %d:%02d", minutes, seconds)
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
}
