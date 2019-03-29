package com.example.pet_app

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.to_do_row.view.*

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return thingsToDoList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater =LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.to_do_row,p0,false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
            val toDoItem= thingsToDoList.get(p1).toString()
            p0.view.txtToDoItem.text=toDoItem
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}