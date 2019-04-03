package com.example.pet_app

class User(var username:String, var password:String, var name: String, var surename: String, age:Int) {
    var age: Int = 0
        set(value){
            if(value<0) throw IllegalArgumentException("Age cannot be negative")

            field=value
        }

    init{
        this.age=age
    }
}