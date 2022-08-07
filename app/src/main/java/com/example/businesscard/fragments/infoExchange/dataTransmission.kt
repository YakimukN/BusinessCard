package com.example.businesscard.fragments.infoExchange

import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.example.businesscard.data.UserData
import com.example.businesscard.databinding.FragmentProfileBinding
import com.example.businesscard.funsDB.APP_ACTIVITY

// then the data will be read from the database
fun sendDataToFragment(dataModel: DataModel, userData: UserData){
    userData.userName = "Alex"
    userData.nameSurname = "Alex Surname"
    userData.carInfo.aboutMe = "I'm not running away from hard work, I'm too lazy to run."
    userData.carInfo.cardType = 2
    userData.carInfo.git = "link to gitHub"
    userData.carInfo.phone = "+375 (**) ***-**-**"
    userData.carInfo.linkedIn = "link to LinkedIn"
    userData.carInfo.whoAreYou = "Who Am I? I Am Wh..."

    dataModel.infoBetweenActivityAndFragment.value = userData
}

fun getDataFromActivity(dataModel: DataModel, binding: FragmentProfileBinding){
    dataModel.infoBetweenActivityAndFragment.observe(APP_ACTIVITY as LifecycleOwner) {

        binding.UserNameProfile.text = it.userName

        if (it.carInfo.cardType == 1){

            binding.cardView1.visibility = View.VISIBLE
            binding.backgroundCardView1.visibility = View.VISIBLE
            binding.cardView2.visibility = View.GONE
            binding.backgroundCardView2.visibility = View.GONE

            binding.nameSurnameCV1.text = it.nameSurname
            binding.aboutMeBCV1.text = it.carInfo.aboutMe
            binding.linkToGitCV1.text = it.carInfo.git
            binding.phoneCV1.text = it.carInfo.phone
            binding.linkToLinCV1.text = it.carInfo.linkedIn
            binding.whoAreYouCV1.text = it.carInfo.whoAreYou
            binding.userNameBCV1.text = it.userName
        } else{

            binding.cardView1.visibility = View.GONE
            binding.backgroundCardView1.visibility = View.GONE
            binding.cardView2.visibility = View.VISIBLE
            binding.backgroundCardView2.visibility = View.VISIBLE

            binding.nameSurnameCV2.text = it.nameSurname
            binding.linkToGitCV2.text = it.carInfo.git
            binding.phoneCV2.text = it.carInfo.phone
            binding.linkToLinCV2.text = it.carInfo.linkedIn
            binding.whoAreYouCV2.text = it.carInfo.whoAreYou
            binding.userNameBCV2.text = it.nameSurname
        }
    }
}