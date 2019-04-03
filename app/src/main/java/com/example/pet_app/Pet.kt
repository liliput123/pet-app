package com.example.pet_app

class Pet(type:String, race: String, age: Int, ageMeasuer: String, gender: String, description: String="", imgUrl: String ) {
   var type: String
    var race: String
    var age: Int = 0
        set(value){
            if(value<0) throw IllegalArgumentException("Age cannot be negative")

            field=value
        }
    var ageMeasuer: String
    var gender: String
    var description: String
    var imgUrl: String

    init{
        this.type=type
        this.race=race
        this.age=age
        this.ageMeasuer=ageMeasuer
        this.gender=gender
        this.description=description
        this.imgUrl=imgUrl
    }
}