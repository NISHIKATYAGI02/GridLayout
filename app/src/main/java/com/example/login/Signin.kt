package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivitySigninBinding
import com.google.firebase.auth.FirebaseAuth

class Signin : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.textView10.setOnClickListener{
            val intent = Intent(this,signup::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val email = binding.textView3.text.toString()
            val pass = binding.textView4.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty() ){

                    firebaseAuth.signInWithEmailAndPassword(email , pass).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,"it.exception.toStrings()", Toast.LENGTH_SHORT).show()
                        }
                    }

            }else{
                Toast.makeText(this,"Empty Fields Are not Allowed !!" , Toast.LENGTH_SHORT).show()
            }

        }
    }
}