package com.example.pet_app


import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.navigation.Navigation
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.android.synthetic.main.fragment_change_password.*



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ChangePasswordFragment : Fragment() {

    private val currentUser= FirebaseAuth.getInstance().currentUser
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_change_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonChangePassword.setOnClickListener {
            val password= editTextOldPassword.text.toString()

            if(password.isEmpty()){
                editTextOldPassword.error= "Password required"
                editTextOldPassword.requestFocus()
                return@setOnClickListener
            }

            val newPssword= editTextNewPassword.text.toString().trim()

            if(newPssword.isEmpty() || password.length<6) {
                editTextNewPassword.error="Password needs to be at least 6 characters long"
                editTextNewPassword.requestFocus()
                return@setOnClickListener
            }

            val newPassword2= editTextNewPassword2.text.toString().trim()

            if(newPssword!=newPassword2) {
                editTextNewPassword2.error="Password does not match"
                editTextNewPassword2.requestFocus()
                return@setOnClickListener
            }


            currentUser?.let { user->
                val credential= EmailAuthProvider.getCredential(user.email!!, password)
                progressBar.visibility=View.VISIBLE
                user.reauthenticate(credential).addOnCompleteListener{task ->
                    when {
                        task.isSuccessful -> {
                            progressBar.visibility=View.GONE

                            user.updatePassword(newPssword).addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val action = ChangePasswordFragmentDirections.actionPasswodUpdated()
                                    Navigation.findNavController(it).navigate(action)
                                    this.context?.toast("Password changed")
                                } else {
                                    this.context?.toast(task.exception?.message!!)
                                }
                            }
                        }
                        task.exception is FirebaseAuthInvalidCredentialsException -> {
                            editTextOldPassword.error = "Invalid Password"
                            editTextOldPassword.requestFocus()
                        }
                        else -> context?.toast(task?.exception?.message!!)
                        }
                    }
                }

            }
        }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imgResource= R.drawable.changepasswordimage
        if (imgResource != null) {
            val img= BitmapFactory.decodeResource(resources, imgResource)
            val round= RoundedBitmapDrawableFactory.create(resources,img)
            round.isCircular=true
            imageChangePassword.setImageDrawable(round)
        }
    }*/
 }



