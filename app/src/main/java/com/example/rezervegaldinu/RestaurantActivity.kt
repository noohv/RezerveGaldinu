package com.example.rezervegaldinu

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

        restaurantImage.setImageResource(intent.getIntExtra("image", R.drawable.logo))
        restaurantName.text = intent.getStringExtra("restaurantName")
        restaurantAddress.text = intent.getStringExtra("averagePrice")
    }
}