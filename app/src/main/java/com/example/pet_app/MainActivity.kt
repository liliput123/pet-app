package com.example.pet_app


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

        lateinit var buttonSignUp: Button
        lateinit var buttonSignIn: Button
        lateinit var buttonContinue: Button

       override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

           buttonSignUp=findViewById(R.id.buttonSignUp)
           buttonSignIn=findViewById(R.id.buttonSignIn)
           buttonContinue= findViewById(R.id.buttonContinue)

           buttonSignUp.setOnClickListener {
               val intent= Intent(this, SignUpActivity::class.java)
               startActivity(intent)

           }

           buttonContinue.setOnClickListener {
               val intent=Intent(this, AdvertisementActivity::class.java)
               startActivity(intent)
           }


        /*addNewThingBtn.setOnClickListener {
            val newThing = newThingTxt.text.toString()
            thingsToDoList.add(newThing)
            newThingTxt.text.clear()
        }

        viewToDoListBtn.setOnClickListener {
            val intent= Intent(this, ToDoListActivity::class.java)
            startActivity(intent)
        }*/
    }


}