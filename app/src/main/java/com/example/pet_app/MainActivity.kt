package com.example.pet_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

val thingsToDoList = arrayListOf<String>()
class MainActivity : AppCompatActivity() {

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addNewThingBtn.setOnClickListener {
            val newThing = newThingTxt.text.toString()
            thingsToDoList.add(newThing)
            newThingTxt.text.clear()
        }

        viewToDoListBtn.setOnClickListener {
            val intent= Intent(this, ToDoListActivity::class.java)
            startActivity(intent)
        }
    }
}