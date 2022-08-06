package com.example.businesscard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.example.businesscard.databinding.ActivitySignUpBinding
import com.example.businesscard.funsDB.checkUserName
import com.example.businesscard.funsDB.createDataInDB
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private var email = ""
    private var userName = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signUpBtn.setOnClickListener {
            validateData()
        }

        binding.haveAccountTv.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun validateData() {
        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEd.text.toString().trim()
        userName = binding.userNameEd.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailEt.error = "Invalid email format"
        } else if (userName.isEmpty()){
            binding.userNameEd.error = "Please enter UserName"
        } else if (checkUserName(userName)){
            Toast.makeText(this, "This username is used", Toast.LENGTH_SHORT).show()
        } else  if (TextUtils.isEmpty(password)) {
            binding.passwordEd.error = "Please enter password"
        } else if (password.length < 6) {
            binding.passwordEd.error = "Password must atleast 6 chracters long"
        } else  firebaseSignUp()
    }

    private fun firebaseSignUp() {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                createDataInDB(userName, email)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Login failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}