package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Timer


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signInButton = findViewById<Button>(R.id.signInButton) // R = spatiu automat compilat din Res, resurse. are toate informatiile din Res
        val usernameField = findViewById<EditText>(R.id.usernameField)
        val usernameError = findViewById<TextView>(R.id.usernameError)

        val passwordField = findViewById<EditText>(R.id.passwordFieldNew)
        val passwordError = findViewById<TextView>(R.id.passwordError)

        val loginCredentialsText = findViewById<TextView>(R.id.loginCredentialsText)

        signInButton.setOnClickListener { /*
            if(usernameField.text.length <= 2) {
                usernameError.text = "Username is too short"
                usernameError.setTextColor(Color.RED)
            } else {
                usernameError.text = ""
            }

            //if(passwordField.text.length <= 5) {
            if(passwordField.text.length <= 2) {
                passwordError.text = "Password is too short"
                passwordError.setTextColor(Color.RED)
            } else {
                passwordError.text = ""
                loginCredentialsText.text = ""
            }

            if(usernameField.text.length == 0) {
                usernameError.text = "Username cannot be empty"
                usernameError.setTextColor(Color.RED)
            }

            if(passwordField.text.length == 0) {
                passwordError.text = "Password cannot be empty"
                passwordError.setTextColor(Color.RED)
            }

            //if(passwordField.text.toString().equals("password") && usernameField.text.toString().equals("admin")) {
            if(passwordField.text.toString().equals("123") && usernameField.text.toString().equals("123")) {
                loginCredentialsText.text = "Login successful"
                loginCredentialsText.setTextColor(Color.GREEN)

                val intent = Intent(this, OffersListActivity::class.java)
                startActivity(intent)

            } else {
                loginCredentialsText.text = "Invalid credentials"
                loginCredentialsText.setTextColor(Color.RED)
            } */

            val intent = Intent(this, OffersListActivity::class.java)
            startActivity(intent)
        }

    }
}