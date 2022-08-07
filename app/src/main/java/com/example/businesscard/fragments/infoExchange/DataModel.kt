package com.example.businesscard.fragments.infoExchange

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.businesscard.data.UserData

open class DataModel : ViewModel() {
    val infoBetweenActivityAndFragment: MutableLiveData<UserData> by lazy {
        MutableLiveData<UserData>()
    }
}