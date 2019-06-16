package com.example.pet_app


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.pet_app.R.array.pet_types
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_new_advertisement.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class NewAdvertisementFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_advertisement, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val types= ArrayList<String>()
        types.add("Dog")
        types.add("Cat")
        types.add("Other")

        spinnerType.adapter = ArrayAdapter(getActivity(),R.layout.support_simple_spinner_dropdown_item, types)
        spinnerType.setSelection(1)

        buttonAdd.setOnClickListener {
            val type= spinnerType.selectedItem.toString()
            val race= editTextRace.text.toString()
            val gender= editTextGender.text.toString()
            val description= editTextDescription.text.toString()
            val city= editTextCity.text.toString()

            val email= FirebaseAuth.getInstance().currentUser?.email

            if(race.isEmpty()){
                editTextRace.error = "This field is required"
                editTextRace.requestFocus()
                return@setOnClickListener
            }
            if(gender.isEmpty()){
                editTextGender.error = "This field is required"
                editTextGender.requestFocus()
                return@setOnClickListener
            }
            if(description.isEmpty()){
                editTextDescription.error = "This field is required"
                editTextDescription.requestFocus()
                return@setOnClickListener
            }
            if(city.isEmpty()){
                editTextCity.error = "This field is required"
                editTextCity.requestFocus()
                return@setOnClickListener
            }

            val advertisements=FirebaseDatabase.getInstance().getReference("advertisements")
            progressBar2.visibility=View.VISIBLE
            val key=advertisements.push().key
            val pet= Pet(type,race,gender,description,"")
            val advertisement= Advertisement(pet, email!!.md5(), city)
            advertisements.child(key).setValue(advertisement).addOnCompleteListener {task->
                progressBar2.visibility=View.GONE
                if(task.isSuccessful){
                    activity?.toast("The advertisement has been added")
                }
                else{
                    activity?.toast(task.exception?.message.toString())
                }

            }

        }

    }
}
