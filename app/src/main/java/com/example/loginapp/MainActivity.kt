package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.loginButton)
        val createUserTextView: TextView = findViewById(R.id.createUserTextView)

        emailEditText.setText("xyz@gmail.com")

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateInput(email, password)) {
                // Переход на экран приветствия
                navigateToWelcomeScreen(email)
            }
        }

        createUserTextView.setOnClickListener {
            Toast.makeText(this, "Создание пользователя", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            emailEditText.error = "Введите email"
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Введите правильный email"
            return false
        }

        if (password.isEmpty()) {
            passwordEditText.error = "Введите пароль"
            return false
        }

        if (password.length < 6) {
            passwordEditText.error = "Пароль должен быть не менее 6 символов"
            return false
        }

        return true
    }

    private fun navigateToWelcomeScreen(email: String) {
        // Создаем Intent для перехода на WelcomeActivity
        val intent = Intent(this, WelcomeActivity::class.java)

        // Передаем email пользователя
        intent.putExtra("USER_EMAIL", email)

        // Запускаем новую активность
        startActivity(intent)

        // Опционально: закрываем текущую активность
        // finish()

        Toast.makeText(this, "Успешный вход!", Toast.LENGTH_SHORT).show()
    }

    // Добавьте эти переменные как свойства класса
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onStart() {
        super.onStart()
        // Инициализация после setContentView
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
    }
}