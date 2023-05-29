package com.example.rezervegaldinu

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ManasRezervacijas : AppCompatActivity() {
    lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manas_rezervacijas)
        val book1 = findViewById<TextView>(R.id.book1)
        val book2 = findViewById<TextView>(R.id.book2)
        val book3 = findViewById<TextView>(R.id.book3)
        val book4 = findViewById<TextView>(R.id.book4)
        val backBtn = findViewById<Button>(R.id.atpakalBtn)


        prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.getString("Restorāns 1", "no id")?.let {
            if(it != "no id") {
                book1.text = it
            }
        }
        prefs.getString("Restorāns 2", "no id")?.let {
            if(it != "no id") {
                book2.text = it
            }
        }
        prefs.getString("Restorāns 3", "no id")?.let {
            if(it != "no id") {
                book3.text = it
            }
        }
        prefs.getString("Restorāns 4", "no id")?.let {
            if(it != "no id") {
                book4.text = it
            }
        }

        backBtn.setOnClickListener {
            finish()
        }
    }
}