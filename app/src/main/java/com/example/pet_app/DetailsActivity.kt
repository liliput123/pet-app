package com.example.pet_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DetailsActivity : AppCompatActivity() {

    //need to connect it to the main activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}
