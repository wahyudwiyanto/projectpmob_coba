package com.example.coba

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class JoggingDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "jogging.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "jogging"
        const val COLUMN_ID = "id"
        const val COLUMN_DATE = "date"
        const val COLUMN_DURATION = "duration"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_DATE TEXT NOT NULL,
                $COLUMN_DURATION INTEGER NOT NULL
            )
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertJoggingData(date: String, duration: Int): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_DATE, date)
            put(COLUMN_DURATION, duration)
        }
        return db.insert(TABLE_NAME, null, values)
    }

    fun getAllJoggingData(): List<String> {
        val db = readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(COLUMN_DATE, COLUMN_DURATION),
            null,
            null,
            null,
            null,
            "$COLUMN_DATE ASC"
        )
        val data = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                val date = getString(getColumnIndexOrThrow(COLUMN_DATE))
                val duration = getInt(getColumnIndexOrThrow(COLUMN_DURATION))
                data.add("Date: $date, Duration: $duration minutes")
            }
        }
        cursor.close()
        return data
    }

    // Fungsi untuk menghapus semua data jogging
    fun clearAllJoggingData(): Int {
        val db = writableDatabase
        val rowsDeleted = db.delete(TABLE_NAME, null, null)
        return rowsDeleted
    }
}
