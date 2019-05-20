package com.example.pet_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var editTextSurname: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var editTextPassword2: EditText
    lateinit var buttonSignUp: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        editTextName= findViewById(R.id.editTextName)
        editTextSurname= findViewById(R.id.editTextSurname)
        editTextEmail= findViewById(R.id.editTextEmail)
        editTextPassword= findViewById(R.id.editTextPassword)
        editTextPassword2= findViewById(R.id.editTextPassword2)
        buttonSignUp= findViewById(R.id.buttonSignUp2)


        buttonSignUp.setOnClickListener {
            saveUser()
        }

        buttonHaveAccountSignIn.setOnClickListener {
            val intent= Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveUser() {
        val name = editTextName.text.toString().trim()
        val surname = editTextSurname.text.toString().trim()
        val email = editTextEmail.text.toString().trim()
        val password = editTextPassword.text.toString().trim()
        val password2 = editTextPassword2.text.toString().trim()

        if(checkUser(name,surname,email,password, password2)==-1){
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("users")
        val userId = ref.push().key
        val user = User(userId, name, surname, email, password)
        ref.child(userId).setValue(user).addOnCompleteListener {
             toast("You have signed up successfuly")
        }

        val aut = FirebaseAuth.getInstance()
        aut.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
             if (task.isSuccessful) {

                 //needs to display an activity for the logged in user, but still not created
             } else {
                 task.exception?.message?.let {
                 toast(it)
              }
             }
        }
    }

    fun checkUser(name: String, surname:String, email:String, password:String, password2:String): Int{

        if(name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty() || password2.isEmpty()){
            toast("All the fields are required")
            return -1
        }
        val checkerValue = checkEmailAndPassword(email, password)
        if (checkerValue == -2) {
            editTextEmail.error = "Invalid email format"
            editTextEmail.requestFocus()
            return -1
        }
        if (checkerValue == -3) {
            editTextPassword.error = "The password must be at least 6 characters long"
            editTextPassword.requestFocus()
            editTextPassword2.text.clear()
            return -1
        }
        if(password!=password2){
            toast("Your passwords don't match, enter them again!")
            editTextPassword.text.clear()
            editTextPassword2.text.clear()
            return -1
        }

        return 0
    }
}


