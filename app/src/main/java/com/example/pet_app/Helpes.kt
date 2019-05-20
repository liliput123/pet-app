package com.example.pet_app

import android.content.Context
import android.util.Patterns
import android.widget.Toast

fun Context.toast(message:String){
    Toast.makeText(this, message,Toast.LENGTH_LONG).show()
}

fun checkEmailAndPassword(email:String, password:String): Int{
    if(email.isEmpty()){
        return -1 //email is empty
    }
    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
        return -2 //email is in the wrong format
    }
    if(password.isEmpty() || password.length<6){
        return -3 //password needs to be at least 6 characters long
    }

    return 0 // everything is okay
}