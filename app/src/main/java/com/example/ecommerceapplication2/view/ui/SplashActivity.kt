package com.example.ecommerceapplication2.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.ecommerceapplication2.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN

        )

        Handler().postDelayed({
            //Launch the MainActivity
            startActivity(
                Intent (this@SplashActivity,
                MainActivity::class.java)
            )
            finish() //call this when your activity is done and should be closed.
        },
            1500
        )

    }
}