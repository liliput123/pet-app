package com.example.pet_app

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class Advertisement(val pet: Pet, val user:User, var city:String, var email:String, var phone:String="") {
    var date: String=""

    init{
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val date = sdf.format(Date())
    }

}