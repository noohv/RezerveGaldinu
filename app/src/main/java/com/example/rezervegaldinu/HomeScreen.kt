package com.example.rezervegaldinu

import android.app.Person
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rezervegaldinu.databinding.ActivityHomeScreenBinding
import com.example.rezervegaldinu.databinding.ActivityMainBinding
import java.util.jar.Attributes


class HomeScreen : AppCompatActivity() {
    private lateinit var binding : ActivityHomeScreenBinding
    private lateinit var restaurantArrayList : ArrayList<Restaurant>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intentUser = intent.getSerializableExtra("user") as User
        val user = User(intentUser.name, intentUser.phone, intentUser.email)

        val imageId = intArrayOf(
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo
        )

        val restaurantName = arrayOf(
            "Itallisimo",
            "Olīve",
            "SushiBoom",
            "Gruzīņu Restorāns"
        )

        val averagePrices = arrayOf(
            "25€",
            "30€",
            "15€",
            "20€"
        )

        val countries = arrayOf(
            "Itāļu",
            "Dažādi",
            "Āzijas",
            "Gruzīņu"
        )

        restaurantArrayList = ArrayList()

        for(i in restaurantName.indices) {
            val restaurant = Restaurant(restaurantName[i], averagePrices[i], countries[i], imageId[i])
            restaurantArrayList.add(restaurant)
        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this, restaurantArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->
            val restaurantName = restaurantName[position]
            val averagePrice = averagePrices[position]
            val country = countries[position]
            val imageId = imageId[position]

            val i = Intent(this, RestaurantActivity::class.java)
            i.putExtra("restaurantName", restaurantName)
            i.putExtra("averagePrice", averagePrice)
            i.putExtra("country", country)
            i.putExtra("image", imageId)
            i.putExtra("user", user)
            startActivity(i)
        }

    }

}