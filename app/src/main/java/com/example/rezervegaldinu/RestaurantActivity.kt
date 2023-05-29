package com.example.rezervegaldinu

import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class RestaurantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val restaurantImage = findViewById<ImageView>(R.id.restImage)
        val restaurantName = findViewById<TextView>(R.id.restName)
        val restaurantAddress = findViewById<TextView>(R.id.address)
        val bookButton = findViewById<Button>(R.id.bookTableBtn)
        val backButton = findViewById<Button>(R.id.backBtn)
        val intentUser = intent.getSerializableExtra("user") as User
        val user = User(intentUser.name, intentUser.phone, intentUser.email)


        restaurantImage.setImageResource(intent.getIntExtra("image", R.drawable.logo))
        restaurantName.text = intent.getStringExtra("restaurantName")
        restaurantAddress.text = intent.getStringExtra("address")

        bookButton.setOnClickListener {
            val intent = Intent(this, BookTableActivity::class.java)
            intent.putExtra("restaurantName", restaurantName.text)
            intent.putExtra("user", user)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}