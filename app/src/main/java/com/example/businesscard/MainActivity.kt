package com.example.businesscard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.businesscard.databinding.ActivityMainBinding
import com.example.businesscard.fragments.FavoriteFragment
import com.example.businesscard.fragments.HelpFragment
import com.example.businesscard.fragments.HomeFragment
import com.example.businesscard.fragments.ProfileFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val helpFragment = HelpFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(homeFragment)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }



        binding.bottomNavigationView.background = null



        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(homeFragment)
                R.id.favorite -> replaceFragment(favoriteFragment)
                R.id.help -> replaceFragment(helpFragment)
                R.id.profile -> replaceFragment(profileFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()

    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            val email = firebaseUser.email
            binding.emailTv.text = email
        } else {
            startActivity(Intent(this, HelloActivity::class.java))
            finish()
        }
    }
}