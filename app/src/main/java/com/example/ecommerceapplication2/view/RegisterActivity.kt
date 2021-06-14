package com.example.ecommerceapplication2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ecommerceapplication2.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance();

        //navigate to login activity
        buttonWithAccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btn_register.setOnClickListener {
            if (et_email.text.isNotEmpty() || et_cpassword.text.isNotEmpty() || et_password.text.isNotEmpty()) {
                registerUser();
            } else {
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()

            }
        }

    }

    private fun registerUser() {
        auth.createUserWithEmailAndPassword(
            et_email.text.trim().toString(),
            et_password.text.trim().toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this, "Registered Successful", Toast.LENGTH_LONG).show()


                } else {

                    Toast.makeText(this, "Register Failed" + task.exception, Toast.LENGTH_LONG)
                        .show()

                }
            }
        fun onStart() {
            super.onStart()
            val user = auth.currentUser;
            if (user != null) {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            } else {
                Log.e("user status", "usernull")
            }
        }
    }
}