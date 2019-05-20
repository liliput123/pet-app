package com.example.pet_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth=FirebaseAuth.getInstance()

        buttonSignIn.setOnClickListener {
            val email=editTextEmail.text.toString().trim()
            val password=editTextPassword.text.toString().trim()
            val checkerValue= checkEmailAndPassword(email,password)
            if(checkerValue==-1){
                editTextEmail.error="You need to enter an email address"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }
            if(checkerValue==-2){
                editTextEmail.error="Invalid email format"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }
            if(checkerValue==-3){
                editTextPassword.error="The password must be at least 6 characters long"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            logInUser(email, password)
        }

    }

    private fun logInUser(email:String, password:String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){ task->
            if(task.isSuccessful){
                //open the logged in user form (is not yet done)
            }
            else{
                task.exception?.message?.let {
                    toast(it)
                }
            }

        }
    }
}
