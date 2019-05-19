package com.example.pet_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var editTextSurname: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextPhone: EditText
    lateinit var editTextPassword: EditText
    lateinit var editTextPassword2: EditText
    lateinit var buttonSignUp: Button
    lateinit var spinnerCity: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        editTextName= findViewById(R.id.editTextName)
        editTextSurname= findViewById(R.id.editTextSurname)
        editTextEmail= findViewById(R.id.editTextEmail)
        editTextPhone= findViewById(R.id.editTextPhone)
        editTextPassword= findViewById(R.id.editTextPassword)
        editTextPassword2= findViewById(R.id.editTextPassword2)
        buttonSignUp= findViewById(R.id.buttonSignUp)
        spinnerCity=findViewById(R.id.spinnerCity)

        val cities= arrayListOf<String>("Berlin", "Dortmund", "Hamburg")

        spinnerCity.adapter= ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, cities)

        buttonSignUp.setOnClickListener {
            saveUser()
        }
    }

    private fun saveUser(){
        val name= editTextName.text.toString().trim()
        val surname=editTextSurname.text.toString().trim()
        val email= editTextEmail.text.toString().trim()
        val phone= editTextPhone.text.toString().trim()
        val password= editTextPassword.text.toString().trim()
        val password2= editTextPassword2.text.toString().trim()
        val city=spinnerCity.selectedItem.toString()

        if(name.isEmpty() || surname.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || password2.isEmpty() || city.isEmpty()){
            Toast.makeText(applicationContext, "You need to fill in all of the fields", Toast.LENGTH_LONG).show()
            return
        }
        if (password!=password2){
            Toast.makeText(applicationContext, "Your passwords don't match, please enter them again", Toast.LENGTH_LONG).show()
            editTextPassword.text.clear()
            editTextPassword2.text.clear()
            return
        }


        val ref= FirebaseDatabase.getInstance().getReference("users")
        val userId= ref.push().key
        val user= User(userId, name, surname, email, phone, city, password)
        ref.child(userId).setValue(user).addOnCompleteListener{
            Toast.makeText(applicationContext, "You have signed up successfuly", Toast.LENGTH_LONG).show()
        }


    }
}
