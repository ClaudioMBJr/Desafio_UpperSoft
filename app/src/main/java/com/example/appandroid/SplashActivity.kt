package com.example.appandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        changeToMain()
    }

    fun changeToMain() {
        val intent = Intent (this, MainActivity::class.java)
        Handler().postDelayed({
            intent.change()
        },2000)
    }

    fun Intent.change(){
        startActivity(this)
        finish()
    }
}