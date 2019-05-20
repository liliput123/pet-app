package com.example.pet_app


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        lateinit var buttonSignUp2: Button
        lateinit var buttonSignIn2: Button
        lateinit var buttonContinue: Button

       override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

           buttonSignUp2=findViewById(R.id.buttonSignUp2)
           buttonSignIn2=findViewById(R.id.buttonSignIn2)
           buttonContinue= findViewById(R.id.buttonContinue)

           buttonSignUp2.setOnClickListener {
               val intent= Intent(this, SignUpActivity::class.java)
               startActivity(intent)

           }

           buttonContinue.setOnClickListener {
               val intent=Intent(this, AdvertisementActivity::class.java)
               startActivity(intent)
           }

           buttonSignIn2.setOnClickListener {
               val intent=Intent(this, SignInActivity::class.java)
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