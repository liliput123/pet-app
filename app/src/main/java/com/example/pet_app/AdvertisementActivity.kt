package com.example.pet_app


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.Collections.unmodifiableMap
import android.R.*
import androidx.recyclerview.widget.RecyclerView


var advertisementsList = arrayListOf<Advertisement>()
val user= User("kika", "123aba", "Kristina", "Kristina")
val pet1= Pet("Dog", "Pomeranian", 6, "months", "male", "cute puppy", "pet1")
val pet2= Pet("Dog", "Pug", 7, "months", "male", "cute puppy", "pet2")
val pet3= Pet("Dog", "Dobermann", 1, "year", "female", "cute puppy", "pet3")
val pet4= Pet("Cat", "Bengal cat", 2, "years", "female", "cute puppy", "pet4")
val pet5= Pet("Cat", "Persian cat", 6, "months", "male", "cute puppy", "pet5")


val petImages= HashMap<String,Int>()

class AdvertisementActivity : AppCompatActivity() {

    lateinit var rcvAdvertisements: androidx.recyclerview.widget.RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertisement)

        rcvAdvertisements= findViewById(R.id.rcvAdvertisements)
        rcvAdvertisements.layoutManager= androidx.recyclerview.widget.LinearLayoutManager(this)
        rcvAdvertisements.adapter=MainAdapter()
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
