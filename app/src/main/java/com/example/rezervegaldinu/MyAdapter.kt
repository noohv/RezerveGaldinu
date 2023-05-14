package com.example.rezervegaldinu

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context : Activity, private val arrayList : ArrayList<Restaurant>) : ArrayAdapter<Restaurant> (context,
R.layout.list_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater =  LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item, null)

        val imageView : ImageView = view.findViewById(R.id.restaurantPic)
        val restaurantName : TextView = view.findViewById(R.id.restaurantName)
        val averagePrice : TextView = view.findViewById(R.id.averagePrice)
        val cuisineCountry : TextView = view.findViewById(R.id.cuisineCountry)

        imageView.setImageResource(arrayList[position].imageId)
        restaurantName.text = arrayList[position].name
        averagePrice.text = arrayList[position].averagePrice
        cuisineCountry.text = arrayList[position].country

        return view
    }
}