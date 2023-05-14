package com.example.rezervegaldinu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val registerButton = findViewById<Button>(R.id.registerSubmitButton)
        val loginButton = findViewById<Button>(R.id.registerSwitchToLogin)
        val nameInputField = findViewById<EditText>(R.id.registerNameInput)
        val emailInputField = findViewById<EditText>(R.id.registerEmailInput)
        val phoneInputField = findViewById<EditText>(R.id.registerPhoneInput)
        val passwordInputField = findViewById<EditText>(R.id.registerPasswordInput)
        val repeatPasswordInputField = findViewById<EditText>(R.id.registerRepeatPassInput)

        registerButton.setOnClickListener {

        }


        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}