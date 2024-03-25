package com.example.loginscreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usernameInput = findViewById(R.id.input_username)
        passwordInput = findViewById(R.id.input_password)
        loginButton = findViewById(R.id.button_login)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            Log.i("Credentials", "Username: $username and Password: $password")
        }

        val secondRouteButton = findViewById<Button>(R.id.register_route)
        secondRouteButton.setOnClickListener {
            val Intent = Intent(this,register::class.java)
            startActivity(Intent)
        }
    }
}