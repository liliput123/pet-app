package com.example.pet_app

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        val imgResource= R.drawable.resetpasswordimage
        if (imgResource != null) {
            val img= BitmapFactory.decodeResource(resources, imgResource)
            val round= RoundedBitmapDrawableFactory.create(resources,img)
            round.isCircular=true
            imageResetPassword.setImageDrawable(round)
        }

        buttonResetPassword.setOnClickListener {
            val email=editTextEmail3.text.toString()
            if(email.isEmpty()){
                editTextEmail3.error="Email required"
                editTextEmail3.requestFocus()
                return@setOnClickListener
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                editTextEmail3.error="Invalid email format"
                editTextEmail3.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        this.toast("Email sent")
                        val intent= Intent(this, SignInActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        this.toast(task.exception?.message!!)
                    }
                }
        }
    }
}
