package com.example.businesscard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.example.businesscard.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.noAccountTv.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.loginBtn.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEd.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailEt.error = "Invalid email format"
        } else if (TextUtils.isEmpty(password)){
            binding.passwordEd.error = "Please enter password"
        } else {
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Login failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}