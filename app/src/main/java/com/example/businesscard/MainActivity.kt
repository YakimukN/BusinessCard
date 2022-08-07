package com.example.businesscard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.businesscard.data.UserData
import com.example.businesscard.databinding.ActivityMainBinding
import com.example.businesscard.fragments.FavoriteFragment
import com.example.businesscard.fragments.HelpFragment
import com.example.businesscard.fragments.HomeFragment
import com.example.businesscard.fragments.ProfileFragment
import com.example.businesscard.fragments.infoExchange.DataModel
import com.example.businesscard.fragments.infoExchange.sendDataToFragment
import com.example.businesscard.funsDB.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val helpFragment = HelpFragment()
    private val profileFragment = ProfileFragment()

    private val dataModel: DataModel by viewModels()
    private var userData = UserData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(homeFragment)

        APP_ACTIVITY = this
        binding.bottomNavigationView.background = null

        sendDataToFragment(dataModel, userData)

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
}