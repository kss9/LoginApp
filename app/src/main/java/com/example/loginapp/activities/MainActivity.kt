package com.example.loginapp.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginapp.R
import com.example.loginapp.api.RetrofitClient
import com.example.loginapp.models.LoginResponseData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        login_btn.setOnClickListener {
            val app_name = "com.tatamotors.egurucrm"
            val app_version = "3.0.0"
            val device_id = "C4D8C9E6-F09B-458E-9491-7343EEE84192"
            val username = username_et.text.toString().trim()
            val password = password_et.text.toString().trim()

            if(username.isEmpty()){
                username_et.error = "Username required"
                username_et.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                password_et.error = "Password required"
                password_et.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.userLogin(app_name, app_version, device_id, username, password)
                .enqueue(object: Callback<LoginResponseData>{
                    override fun onFailure(call: Call<LoginResponseData>, t: Throwable){
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        //Toast.makeText(applicationContext, t.failure.msg, Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse(call: Call<LoginResponseData>, response: Response<LoginResponseData>) {
                        //response.body()?.msg.length

                        var len = response.body()?.data?.get(0)?.organization_name
                        //var len = response.body()?.msg?.length
                            if(len.equals(null))//login fail case
                            {
                               Toast.makeText(applicationContext, "Username and password are not matching.", Toast.LENGTH_LONG).show()
                               //Toast.makeText(applicationContext, response.body()?.msg , Toast.LENGTH_LONG).show()
                            } else //login  case
                            {
                                val access_token: String? = response.body()?.token?.access_token
                                val refresh_token= response.body()?.token?.refresh_token
                                val primary_postnid=response.body()?.data?.get(0)?.primary_postnid
                                val organization_name=response.body()?.data?.get(0)?.organization_name
                                val user_login_s=response.body()?.data?.get(0)?.user_login_s
                                val editor:SharedPreferences.Editor = sharedPreferences.edit()
                                editor.putString("access_token_key",access_token)
                                editor.putString("refresh_token_key",refresh_token)
                                editor.putString("primary_postnid_key",primary_postnid)
                                editor.putString("organization_name_key",organization_name)
                                editor.putString("user_login_s_key",user_login_s)
                                editor.apply()
                                editor.commit()
                                startActivity(Intent(this@MainActivity, OnLogin::class.java))
                            }
                    }
                })
        }
    }
}