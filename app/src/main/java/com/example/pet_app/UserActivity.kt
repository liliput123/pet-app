package com.example.pet_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        setSupportActionBar(toolbar)

        val navController= Navigation.findNavController(this,R.id.fragment)
         NavigationUI.setupWithNavController(navigationView, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.fragment),
                                        drawerLayout)
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }*/

    /*override fun onStart() {
        super.onStart()

        if (FirebaseAuth.getInstance().currentUser==null){
            val intent= Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }*/

    override fun onStart() {
        super.onStart()

        if (FirebaseAuth.getInstance().currentUser == null) {
            val intent= Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}
