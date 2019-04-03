package com.example.pet_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Collections.unmodifiableMap
import android.R.*




var advertisementsList = arrayListOf<Advertisement>()
val user= User("kika", "123aba", "Kristina", "Kristina", 21)
val pet1= Pet("Dog", "Pomeranian", 6, "months", "male", "cute puppy", "pet1")
val pet2= Pet("Dog", "Pug", 7, "months", "male", "cute puppy", "pet2")
val pet3= Pet("Dog", "Dobermann", 1, "year", "female", "cute puppy", "pet3")
val pet4= Pet("Cat", "Bengal cat", 2, "years", "female", "cute puppy", "pet4")
val pet5= Pet("Cat", "Persian cat", 6, "months", "male", "cute puppy", "pet5")


val petImages= HashMap<String,Int>()



class MainActivity : AppCompatActivity() {

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

           rcvAdvertisements.layoutManager= LinearLayoutManager(this)
           rcvAdvertisements.adapter=MainAdapter()
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

    init{
        advertisementsList.add(Advertisement(pet1,user,"Berlin", "tralala1@outlook.com"))
        advertisementsList.add(Advertisement(pet2,user,"Hamburg", "tralala2@outlook.com"))
        advertisementsList.add(Advertisement(pet3,user,"Berlin", "tralala3@outlook.com"))
        advertisementsList.add(Advertisement(pet4,user,"Stuttgart", "tralala4@outlook.com"))
        advertisementsList.add(Advertisement(pet5,user,"Hagen", "tralala5@outlook.com"))

        petImages.put("pet1", R.drawable.pet1)
        petImages.put("pet2", R.drawable.pet2)
        petImages.put("pet3", R.drawable.pet3)
        petImages.put("pet4", R.drawable.pet4)
        petImages.put("pet5", R.drawable.pet5)


    }
}