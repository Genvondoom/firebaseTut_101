package com.example.firebasedoctutorial

import com.google.firebase.database.FirebaseDatabase



data class User(val username:String, val email:String)

fun main(){
    val database = FirebaseDatabase.getInstance().reference
    database.child("test").push().setValue(User("vd","test"))




}