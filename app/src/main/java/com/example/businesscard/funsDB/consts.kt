package com.example.businesscard.funsDB

import com.example.businesscard.MainActivity
import com.google.firebase.auth.FirebaseAuth

lateinit var APP_ACTIVITY: MainActivity

val USER_ID = FirebaseAuth.getInstance().currentUser?.uid.toString()
var firebaseAuth = FirebaseAuth.getInstance()

const val ROOT_USERS = "Users"
const val ROOT_USER_NAMES = "UserNames"

const val CHILD_USER_NAME = "userName"
const val CHILD_EMAIL = "email"