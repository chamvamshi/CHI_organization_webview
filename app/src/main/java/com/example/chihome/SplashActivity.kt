package com.example.chihome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

       Handler().postDelayed({
           val splashintent = Intent(this,MainActivity::class.java)
           startActivity(splashintent)
           finish()
       },2000)


    }
}