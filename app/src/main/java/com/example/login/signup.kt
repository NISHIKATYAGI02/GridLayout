package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.login.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.textView5.setOnClickListener(){
            val intent = Intent(this,Signin::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener{
            val email = binding.textView9.text.toString()
            val pass = binding.textView12.text.toString()
            val confirmPass = binding.textView13.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()){
                if(pass == confirmPass){
                firebaseAuth.createUserWithEmailAndPassword(email , pass).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this,Signin::class.java)
                      startActivity(intent)
                    }else{
                        Toast.makeText(this,"it.exception.toStrings()", Toast.LENGTH_SHORT).show()
                    }
                }
                }else{
                    Toast.makeText(this,"password is not matching" , Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Empty Fields Are not Allowed !!" , Toast.LENGTH_SHORT).show()
            }

        }
    }
}