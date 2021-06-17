package com.example.ecommerceapplication2.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.ecommerceapplication2.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password_activivty.*

class ForgotPasswordActivivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password_activivty)

        btn_submit.setOnClickListener {
            val email:String = ForgotPasswordUsername.text.toString().trim { it<=' ' }
            if (email.isEmpty()){
                Toast.makeText(
                        this,
                        "Please enter email address.",
                        Toast.LENGTH_LONG).show()
            }else{
                circleProgressbar.visibility=View.VISIBLE
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                        .addOnCompleteListener{task ->
                            circleProgressbar.visibility=View.GONE
                           if (task.isSuccessful){
                               Toast.makeText(this,
                               "Email sent successfully to reset your password!",
                               Toast.LENGTH_LONG).show()

                               finish()
                           }else{
                               Toast.makeText(this,
                               task.exception!!.message.toString(),
                               Toast.LENGTH_LONG).show()
                           }
                        }
            }
        }
    }
}