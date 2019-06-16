package com.example.pet_app

import android.content.Context
import android.content.Intent
import android.util.Patterns
import android.widget.Toast
import java.math.BigInteger
import java.security.MessageDigest
import android.provider.SyncStateContract.Helpers.update



fun String.md5(): String {
    try {
        val digest = MessageDigest.getInstance("md5")
        digest.update(toByteArray())
        val bytes = digest.digest()
        val sb = StringBuilder()
        for (i in bytes.indices) {
            sb.append(String.format("%02X", bytes[i]))
        }
        return sb.toString().toLowerCase()
    } catch (exc: Exception) {
        return "" // Impossibru!
    }

}

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

fun Context.login(){
    val intent= Intent(this, UserActivity::class.java)
    startActivity(intent)
}