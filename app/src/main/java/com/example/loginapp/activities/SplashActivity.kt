package com.example.loginapp.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.loginapp.R

class SplashActivity : AppCompatActivity()
{
    private val sharedPrefFile = "kotlinsharedpreference"
    private val splashTime = 5000L
    private lateinit var myHandler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        myHandler = Handler()
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val sharedUserLoginSValue = sharedPreferences.getString("user_login_s_key","")
        if(sharedUserLoginSValue.equals(""))
        {
            myHandler.postDelayed({ goToMainActivity() },splashTime)
        }else//if already login
        {
            myHandler.postDelayed({ goToOnLogin() },splashTime)
        }
    }

    private fun goToMainActivity()
    {
            val mainActivityIntent = Intent(applicationContext, MainActivity::class.java)
            startActivity(mainActivityIntent)
            finish()
    }

    private fun goToOnLogin()
    {
        val onLoginIntent = Intent(applicationContext, OnLogin::class.java)
        startActivity(onLoginIntent)
        finish()
    }
}
