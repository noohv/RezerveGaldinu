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

        val loginSubmitButton = findViewById<Button>(R.id.loginSubmitBtn)
        val registerButton = findViewById<Button>(R.id.noProfileRegisterBtn)

        loginSubmitButton.setOnClickListener {
            if(checkAllFields()) {
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)

                Toast.makeText(
                    this@LoginActivity,
                    "Pieteikšanās veiksmīga",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

    private fun checkAllFields(): Boolean {
        val emailInput = findViewById<EditText>(R.id.loginEmailInput)
        val passwordInput = findViewById<EditText>(R.id.loginPasswordInput)

        if (emailInput!!.length() == 0) {
            emailInput!!.error = "Lauks ir obligāts"
            return false
        }

        if (passwordInput!!.length() == 0) {
            passwordInput!!.error = "Lauks ir obligāts"
            return false
        } else if (passwordInput!!.length() < 8) {
            passwordInput!!.error = "Minimālais simbolu skaits ir 8"
            return false
        }

        return true
    }
}

