package com.example.rezervegaldinu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<EditText>(R.id.loginEmailInput)
        val passwordInput = findViewById<EditText>(R.id.loginPasswordInput)
        val loginSubmitButton = findViewById<Button>(R.id.loginSubmitBtn)
        val registerButton = findViewById<Button>(R.id.noProfileRegisterBtn)

        loginSubmitButton.setOnClickListener {
            val enteredEmail = emailInput.text.toString()
            val enteredPassword = passwordInput.text.toString()
            var toastText = ""

            if(passwordInput.length() < 8) {
                toastText = "Minimālais paroles garums ir 8 simboli"
            }
            if (!enteredEmail.isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(enteredEmail).matches()) {
                toastText = "E-pasta lauks nepareizi aizpildīts"
            }
            if(enteredEmail.isEmpty() && enteredPassword.isEmpty()) {
                toastText = "Aizpildiet visus laukus"
            }
            else {
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
            }

            Toast.makeText(
                this@LoginActivity,
                toastText,
                Toast.LENGTH_SHORT
            ).show()
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

}