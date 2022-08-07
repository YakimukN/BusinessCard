package com.example.businesscard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.businesscard.databinding.FragmentProfileBinding
import com.example.businesscard.fragments.infoExchange.DataModel
import com.example.businesscard.fragments.infoExchange.getDataFromActivity
import com.example.businesscard.funsDB.checkUser
import com.example.businesscard.funsDB.firebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.emailProfile.text = firebaseAuth.currentUser?.email

        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }

        getDataFromActivity(dataModel, binding)
    }
}