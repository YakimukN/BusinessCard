package com.example.businesscard.funsDB

import com.example.businesscard.data.UserData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

private lateinit var database: DatabaseReference

fun createDataInDB(userName: String, email: String){
    val userData = UserData()
    userData.userName = userName
    userData.email = email

    database = Firebase.database.getReference(ROOT_USERS)
    database.child(USER_ID).setValue(userData)
}

