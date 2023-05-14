package com.example.rezervegaldinu

import android.app.DatePickerDialog
import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Calendar

class BookTableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_table)

        val bookTitle = findViewById<TextView>(R.id.bookRestName)
        val bookPerson = findViewById<TextView>(R.id.bookPerson)
        val pickDateBtn = findViewById<Button>(R.id.idBtnPickDate)
        val dateText = findViewById<TextView>(R.id.dateText)
        val peopleInput = findViewById<EditText>(R.id.editTextNumber)
        val submitBtn = findViewById<Button>(R.id.confirmBookBtn)
        val cancelBtn = findViewById<Button>(R.id.cancelBtn)
        var user = intent.getSerializableExtra("user") as User

        val title = intent.getStringExtra("restaurantName")
        bookTitle.text = title

        bookPerson.text = user.name

        pickDateBtn.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->

                    dateText.text =
                        (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                },

                year,
                month,
                day
            )
            // at last we are calling show
            // to display our date picker dialog.
            datePickerDialog.show()
        }

        submitBtn.setOnClickListener {
            finish()
        }


        cancelBtn.setOnClickListener {
            this.finish()
            dateText.text = ""
        }
    }
}