package com.example.pet_app

import android.os.Parcelable
import java.io.Serializable
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class Advertisement(val pet: Pet, val userEmail:String, val city:String): Serializable