package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val welcomeTextView: TextView = findViewById(R.id.welcomeTextView)
        val userEmailTextView: TextView = findViewById(R.id.userEmailTextView)
        val logoutButton: Button = findViewById(R.id.logoutButton)

        // Получаем email из Intent
        val userEmail = intent.getStringExtra("USER_EMAIL") ?: "гость"

        // Устанавливаем приветствие с email пользователя
        userEmailTextView.text = "Пользователь: $userEmail"

        // Обработка кнопки выхода
        logoutButton.setOnClickListener {
            // Возвращаемся на экран входа
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Закрываем текущую активность
        }
    }
}