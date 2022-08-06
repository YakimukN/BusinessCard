package com.example.businesscard.funsDB

import com.google.firebase.auth.FirebaseAuth

val USER_ID = FirebaseAuth.getInstance().currentUser?.uid.toString()

const val ROOT_USERS = "Users"
const val ROOT_USER_NAMES = "UserNames"
