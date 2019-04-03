package com.example.pet_app

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.advertisement_row.view.*

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

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

            if(advertisement.phone.trim()!=""){
                myViewHolder.view.txtContactValue1.text=advertisement.phone
                myViewHolder.view.txtContactValue2.text=advertisement.email
            }else{
                myViewHolder.view.txtContactValue1.text=advertisement.email
            }

            val imgResource= petImages.get(advertisement.pet.imgUrl)
            if (imgResource != null) {
                myViewHolder.view.imgPetValue.setImageResource(imgResource)
            }

    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}