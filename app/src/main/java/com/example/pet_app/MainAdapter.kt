package com.example.pet_app

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.advertisement_row.view.*

class MainAdapter: androidx.recyclerview.widget.RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return advertisementsList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater =LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.advertisement_row,p0,false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(myViewHolder: CustomViewHolder,index: Int) {
            val advertisement= advertisementsList.get(index)
            myViewHolder.view.txtTypeValue.text=advertisement.pet.type + ", " + advertisement.pet.race
            myViewHolder.view.txtCityValue.text=advertisement.city
            myViewHolder.view.txtDateValue.text=advertisement.date
            myViewHolder.view.txtContactValue1.text=advertisement.email


            val imgResource= petImages.get(advertisement.pet.imgUrl)
            if (imgResource != null) {
                myViewHolder.view.imgPetValue.setImageResource(imgResource)
            }

    }
}

class CustomViewHolder(val view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view){

}