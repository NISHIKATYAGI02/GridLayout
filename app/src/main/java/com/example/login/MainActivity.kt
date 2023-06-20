package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var logoutbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logoutbutton = findViewById(R.id.button2)
        logoutbutton.setOnClickListener {
            FirebaseAuth.getInstance().signOut();

            val intent = Intent(this, Signin::class.java)
            startActivity((intent))
            finish()
        }
    }
}