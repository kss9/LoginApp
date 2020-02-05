package com.example.loginapp.activities

import android.content.Intent
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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*login_btn.setOnClickListener{
             var status=if(username_et.text.toString().equals("abc") && password_et.text.toString().equals("abc123")) "login Successful!!" else "Login fail..Try again!"
             Toast.makeText(this,status,Toast.LENGTH_SHORT).show()
        }*/

        login_btn.setOnClickListener {

            /*val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val name = editTextName.text.toString().trim()
            val school = editTextSchool.text.toString().trim()
             */

            val app_name = "com.tatamotors.egurucrm"
            val app_version = "3.0.0"
            val device_id = "C4D8C9E6-F09B-458E-9491-7343EEE84192"
            val username = username_et.text.toString().trim()
            val password = password_et.text.toString().trim()

            /*
            if(email.isEmpty()){
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }


            if(password.isEmpty()){
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if(name.isEmpty()){
                editTextName.error = "Name required"
                editTextName.requestFocus()user_login_s
                return@setOnClickListener
            }

            if(school.isEmpty()){
                editTextSchool.error = "School required"
                editTextSchool.requestFocus()
                return@setOnClickListener
            }
            */


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
                        //response.body()?.data?.get(0)?.organization_name

                        var len = response.body()?.data?.get(0)?.organization_name
                        //var len = response.body()?.msg?.length
                            if(len.equals(null)) {
                               Toast.makeText(applicationContext, "Username and password are not matching.", Toast.LENGTH_LONG).show()
                               //Toast.makeText(applicationContext, response.body()?.msg , Toast.LENGTH_LONG).show()
                                //Toast.makeText()
                            } else
                            {
                                startActivity(Intent(this@MainActivity, OnSuccessLogin::class.java))

                                //Toast.makeText(applicationContext, response.body()?.data?.get(0)?.organization_name , Toast.LENGTH_LONG).show()
                            }


                    }
                })
        }
    }


}
