package com.example.pet_app

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val advertisement=intent.extras.getSerializable("advertisement") as? Advertisement
        textTypeD.text=advertisement?.pet?.type
        textRaceD.text=advertisement?.pet?.race
        textGenderD.text=advertisement?.pet?.gender
        textCityD.text=advertisement?.city
        textDescriptionD.text=advertisement?.pet?.description
        textContactD.text=advertisement?.userEmail
        val imgResource= petImages.get(advertisement?.pet?.imgUrl)
        if (imgResource != null) {
            val img= BitmapFactory.decodeResource(resources, imgResource)
            val round= RoundedBitmapDrawableFactory.create(resources,img)
            round.isCircular=true
            imagePetD.setImageDrawable(round)
        }
    }
}
