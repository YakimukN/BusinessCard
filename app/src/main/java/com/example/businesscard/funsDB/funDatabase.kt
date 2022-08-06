package com.example.businesscard.funsDB

import com.example.businesscard.data.UserData
import com.google.firebase.database.*

private lateinit var database: DatabaseReference

// for new users
fun createDataInDB(userName: String, email: String){
    val userData = UserData()
    userData.userName = userName
    userData.email = email

    database = FirebaseDatabase.getInstance().getReference(ROOT_USERS)
    database.child(USER_ID).setValue(userData)
}

fun checkUserName(userName: String) : Boolean{
    var check = true
    database = FirebaseDatabase.getInstance().getReference(ROOT_USER_NAMES)

    database.addListenerForSingleValueEvent( AppValueEventListener{
        if (it.hasChild(userName))
            check = false
        else database.child(userName).child(CHILD_EMAIL).setValue(USER_ID)
    })

    return check
}