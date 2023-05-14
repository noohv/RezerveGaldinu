package com.example.rezervegaldinu

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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

        registerButton.setOnClickListener {
            if(checkAllFields()) {

                val name = nameInputField.text.toString()
                val email = emailInputField.text.toString()
                val phone = phoneInputField.text.toString()
                val user = User(name.substringBefore('@'), phone, email)

                val intent = Intent(this, HomeScreen::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                intent.putExtra("user", user)
                startActivity(intent)

                Toast.makeText(
                    this@RegisterActivity,
                    "Reģistrācija veiksmīga",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    private fun checkAllFields(): Boolean {
        val nameInputField = findViewById<EditText>(R.id.registerNameInput)
        val emailInputField = findViewById<EditText>(R.id.registerEmailInput)
        val phoneInputField = findViewById<EditText>(R.id.registerPhoneInput)
        val passwordInputField = findViewById<EditText>(R.id.registerPasswordInput)
        val repeatPasswordInputField = findViewById<EditText>(R.id.registerRepeatPassInput)

        if (nameInputField!!.length() == 0) {
            nameInputField.error = "Lauks ir obligāts"
            return false
        }

        if (emailInputField!!.length() == 0) {
            emailInputField.error = "Lauks ir obligāts"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInputField.text.toString()).matches()) {
            emailInputField.error = "Nepareizs epasta formāts"
            return false
        }

        if (phoneInputField!!.length() == 0) {
            phoneInputField.error = "Lauks ir obligāts"
            return false
        } else if(!Patterns.PHONE.matcher(phoneInputField.text.toString()).matches()) {
            phoneInputField.error = "Nepareizs telefona formāts"
            return false
        }

        if (passwordInputField!!.length() == 0) {
            passwordInputField.error = "Lauks ir obligāts"
            return false
        } else if (passwordInputField.length() < 8) {
            passwordInputField.error = "Minimālais simbolu skaits ir 8"
            return false
        }

        if (repeatPasswordInputField!!.length() == 0) {
            repeatPasswordInputField.error = "Lauks ir obligāts"
            return false
        } else if (repeatPasswordInputField.length() < 8) {
            repeatPasswordInputField.error = "Minimālais simbolu skaits ir 8"
            return false
        } else if (repeatPasswordInputField.text.toString() != passwordInputField.text.toString()) {
            repeatPasswordInputField.error = "Paroles nesakrīt"
            return false
        }

        return true
    }
}