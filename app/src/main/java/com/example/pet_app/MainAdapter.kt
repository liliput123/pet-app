package com.example.pet_app


import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.advertisement_row.view.*


class MainAdapter(val advertisementsList: List<Advertisement>, val clickListener: (Advertisement) -> Unit) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return advertisementsList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater =LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.advertisement_row,p0,false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(myViewHolder: CustomViewHolder,index: Int) {
          myViewHolder.bind(advertisementsList.get(index), clickListener)
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){
    fun bind(advertisement: Advertisement, clickListener: (Advertisement) -> Unit) {
        view.textType.text=advertisement.pet.type
        view.textRace.text=advertisement.pet.race
        view.textCity.text=advertisement.city
        val imgResource= petImages.get(advertisement.pet.imgUrl)
        if (imgResource != null) {

            view.imagePet.setImageResource(imgResource)
        }
        view.setOnClickListener { clickListener(advertisement)}
    }
}