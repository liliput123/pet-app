package com.example.pet_app


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_advertisement.*



var advertisementsList = arrayListOf<Advertisement>()
val user= User("kika", "123aba", "Kristina@yahoo.com")
val pet1= Pet("Dog", "Pomeranian", "male", "cute puppy", "pet1")
val pet2= Pet("Dog", "Pug", "male", "cute puppy", "pet2")
val pet3= Pet("Dog", "Dobermann", "female", "cute puppy", "pet3")
val pet4= Pet("Cat", "Bengal cat", "female", "cute puppy", "pet4")
val pet5= Pet("Cat", "Persian cat", "male", "cute puppy", "pet5")


val petImages= HashMap<String,Int>()

class AdvertisementActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertisement)

        rcvAdvertisements.layoutManager= androidx.recyclerview.widget.LinearLayoutManager(this)
        rcvAdvertisements.adapter=MainAdapter(advertisementsList, {advertisement: Advertisement -> advertisementClicked(advertisement) })

    }

    init{
        advertisementsList.add(Advertisement(pet1,"Kristina@yahoo.com","Berlin"))
        advertisementsList.add(Advertisement(pet2,"Kristina@yahoo.com","Hamburg"))
        advertisementsList.add(Advertisement(pet3,"Kristina@yahoo.com","Berlin"))
        advertisementsList.add(Advertisement(pet4,"Kristina@yahoo.com","Stuttgart"))
        advertisementsList.add(Advertisement(pet5,"Kristina@yahoo.com","Hagen"))

        petImages.put("pet1", R.drawable.pet1)
        petImages.put("pet2", R.drawable.pet2)
        petImages.put("pet3", R.drawable.pet3)
        petImages.put("pet4", R.drawable.pet4)
        petImages.put("pet5", R.drawable.pet5)


    }


    private fun advertisementClicked(advertisement: Advertisement) {
        val intent= Intent(this, DetailsActivity::class.java)
        intent.putExtra("advertisement", advertisement)
        startActivity(intent)
    }
}
