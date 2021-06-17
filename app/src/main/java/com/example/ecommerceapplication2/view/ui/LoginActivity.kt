package com.example.ecommerceapplication2.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.ecommerceapplication2.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        auth = FirebaseAuth.getInstance();
//navigate to ForgotPassword Activivty
        ForgetButton.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivivty::class.java)
            startActivity(intent)
        }

        //navigate to register activity
        buttonNoAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {

            if (editUsername.text.trim().isNotEmpty() || editPassword.text.trim().isNotEmpty()) {
            circularProgressbar.visibility=View.VISIBLE
                signInUser();

            } else {
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()

            }
        }

    }

    fun signInUser() {
        auth.signInWithEmailAndPassword(
            editUsername.text.trim().toString(),
            editPassword.text.trim().toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    circularProgressbar.visibility=View.GONE

                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "Authentication Error " + task.exception,
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
        fun onStart() {
            super.onStart()
        }
    }
}