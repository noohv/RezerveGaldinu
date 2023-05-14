package com.example.rezervegaldinu

import java.io.Serializable

data class User(
    val name: String,
    val phone: String,
    val email: String
) : Serializable
