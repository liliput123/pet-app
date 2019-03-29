package com.example.pet_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_to_do_list.*

class ToDoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        rcvToDo.layoutManager= LinearLayoutManager(this)
        rcvToDo.adapter=MainAdapter()

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
    }


}
