package com.example.businesscard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.businesscard.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.signUpBtn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}