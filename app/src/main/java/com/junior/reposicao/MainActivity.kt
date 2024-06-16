package com.junior.reposicao

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.junior.reposicao.R

class MainActivity : ComponentActivity() {

    private val validCredentials = listOf(
        "user1@example.com" to "senha123",
        "user2@example.com" to "senha456",
        "user3@example.com" to "senha789",
        "user4@example.com" to "senha101",
        "user5@example.com" to "senha112"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val loginButton = findViewById<Button>(R.id.buttonLogin)
        val cancelButton = findViewById<Button>(R.id.buttonCancel)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (isValidLogin(email, password)) {
                Toast.makeText(this, "Seja bem-vindo!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email e/ou senha inválidos", Toast.LENGTH_SHORT).show()
            }
        }

        cancelButton.setOnClickListener {
            emailEditText.text.clear()
            passwordEditText.text.clear()
        }
    }

    private fun isValidLogin(email: String, password: String): Boolean {
        return validCredentials.any { it.first == email && it.second == password }
    }
}
