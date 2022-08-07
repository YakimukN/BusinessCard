package com.example.businesscard.funsDB

import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import com.example.businesscard.HelloActivity
import com.example.businesscard.data.UserData
import com.google.firebase.database.*

private lateinit var database: DatabaseReference
//private lateinit var database2: DatabaseReference

// for new users
fun createDataInDB(email: String){
    val userData = UserData()
    userData.email = email

    database = FirebaseDatabase.getInstance().getReference(ROOT_USERS)
    database.child(USER_ID).setValue(userData)
}

fun checkUser() {
    val firebaseUser = firebaseAuth.currentUser
    if (firebaseUser == null)
        APP_ACTIVITY.startActivity(Intent(APP_ACTIVITY, HelloActivity::class.java))
}





//fun checkUserName(userName: String){
//    database2 = FirebaseDatabase.getInstance().getReference(ROOT_USER_NAMES)
//
//    database2.addListenerForSingleValueEvent(AppValueEventListener{
//        if (!it.hasChild(userName))
//            database2.child(userName).child(CHILD_EMAIL).setValue(USER_ID)
//    })
//}