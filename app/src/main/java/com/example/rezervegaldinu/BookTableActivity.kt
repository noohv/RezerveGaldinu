package com.example.rezervegaldinu

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class BookTableActivity : AppCompatActivity() {
    lateinit var btnDatePicker: Button
    lateinit var btnTimePicker: Button
    lateinit var txtDate: EditText
    lateinit var txtTime: EditText
    var mYear: Int = 0
    var mMonth: Int = 0
    var mDay: Int = 0
    var mHour: Int = 0
    var mMinute: Int = 0
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_table)

        val bookTitle = findViewById<TextView>(R.id.bookRestName)
        val bookPerson = findViewById<TextView>(R.id.bookPerson)
        val peopleInput = findViewById<EditText>(R.id.editTextNumber)
        val submitBtn = findViewById<Button>(R.id.confirmBookBtn)
        val cancelBtn = findViewById<Button>(R.id.cancelBtn)
        var user = intent.getSerializableExtra("user") as User



        btnDatePicker=findViewById<Button>(R.id.btn_date);
        btnTimePicker=findViewById<Button>(R.id.btn_time);
        txtDate=findViewById<EditText>(R.id.in_date);
        txtTime=findViewById<EditText>(R.id.in_time);

        val title = intent.getStringExtra("restaurantName")
        bookTitle.text = title

        bookPerson.text = "Galdiņš tiks rezervēts uz\n" +
                "${user.name}\n" +
                "${user.email}\n" +
                "${user.phone}"

        btnDatePicker.setOnClickListener {
            val datePicker = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    // Do something with the selected date
                    // For example, display it in a TextView
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(year, monthOfYear, dayOfMonth)
                    val formattedDate = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(selectedDate.time)
                    // Update a TextView with the selected date
                    txtDate.setText(formattedDate)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        btnTimePicker.setOnClickListener {
            val timePicker = TimePickerDialog(
                this,
                { _, mHour, mMinute ->
                    // Do something with the selected time
                    // For example, display it in a TextView
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY, mHour)
                    selectedTime.set(Calendar.MINUTE, mMinute)
                    val formattedTime = SimpleDateFormat("HH:mm", Locale.US).format(selectedTime.time)
                    // Update a TextView with the selected time
                    txtTime.setText(formattedTime)
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            )
            timePicker.show()
        }






        submitBtn.setOnClickListener {
            finish()
        }


        cancelBtn.setOnClickListener {
            this.finish()
        }
    }
}