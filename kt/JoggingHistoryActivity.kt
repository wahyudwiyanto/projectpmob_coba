package com.example.coba

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class JoggingHistoryActivity : AppCompatActivity() {

    private lateinit var historyListView: ListView
    private lateinit var clearHistoryButton: Button
    private lateinit var databaseHelper: JoggingDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogging_history)

        // Inisialisasi UI
        historyListView = findViewById(R.id.historyListView)
        clearHistoryButton = findViewById(R.id.clearHistoryButton)

        // Inisialisasi database helper
        databaseHelper = JoggingDatabaseHelper(this)

        // Ambil data jogging dari database
        val joggingHistory = databaseHelper.getAllJoggingData()

        // Set adapter untuk ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, joggingHistory)
        historyListView.adapter = adapter

        // Set listener untuk tombol Clear History
        clearHistoryButton.setOnClickListener {
            clearJoggingHistory()
        }
    }

    // Fungsi untuk menghapus riwayat jogging
    private fun clearJoggingHistory() {
        val deletedRows = databaseHelper.clearAllJoggingData()
        if (deletedRows > 0) {
            Toast.makeText(this, "Jogging history cleared", Toast.LENGTH_SHORT).show()
            // Update ListView setelah menghapus data
            val updatedHistory = databaseHelper.getAllJoggingData()
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, updatedHistory)
            historyListView.adapter = adapter
        } else {
            Toast.makeText(this, "Failed to clear history", Toast.LENGTH_SHORT).show()
        }
    }
}
