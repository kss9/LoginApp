package com.example.loginapp.activities


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.R
import com.example.loginapp.utility.RealPathUtil
import kotlinx.android.synthetic.main.activity_on_login.*


class OnLogin : AppCompatActivity() {

     private val sharedPrefFile = "kotlinsharedpreference"
     private var button: Button? = null
     private var textView: TextView? = null
     private val REQUEST_GALLERY =1


    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_on_login)

        button = findViewById<View>(R.id.button) as Button
        textView = findViewById<View>(R.id.textView) as TextView

         val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

         val sharedAccessTokenValue = sharedPreferences.getString("access_token_key","defaultname")
         val sharedRefreshTokenValue = sharedPreferences.getString("refresh_token_key","defaultname")
         val sharedPrimaryPostnIdValue = sharedPreferences.getString("primary_postnid_key","defaultname")
         val sharedOrganizationNameValue = sharedPreferences.getString("organization_name_key","defaultname")
         val sharedUserLoginSValue = sharedPreferences.getString("user_login_s_key","defaultname")


        if(sharedAccessTokenValue.equals("defaultname") && sharedRefreshTokenValue.equals("defaultname") && sharedPrimaryPostnIdValue.equals("defaultname") && sharedOrganizationNameValue.equals("defaultname") && sharedUserLoginSValue.equals("defaultname")){
            //ShowId.setText("default id: ${sharedIdValue.toString()}")
            Toast.makeText(applicationContext, "hello", Toast.LENGTH_LONG).show()

        }else{
           // textView!!.text=sharedAccessTokenValue+" "+sharedRefreshTokenValue+" "+sharedPrimaryPostnIdValue+" "+sharedOrganizationNameValue+" "+sharedUserLoginSValue
            //ShowName.setText().toString()
            //ShowId.setText(sharedIdValue.toString())
            textView!!.setText(sharedAccessTokenValue+" "+sharedRefreshTokenValue+" "+sharedPrimaryPostnIdValue+" "+sharedOrganizationNameValue+" "+sharedUserLoginSValue).toString()
            Toast.makeText(applicationContext, "hii", Toast.LENGTH_LONG).show()

        }


        /*val sharedIdValue = sharedPreferences.getInt("id_key",0)
        val sharedNameValue = sharedPreferences.getString("name_key","defaultname")
        if(sharedIdValue.equals(0) && sharedNameValue.equals("defaultname")){
            ShowName.setText("default name: ${sharedNameValue}").toString()
            ShowId.setText("default id: ${sharedIdValue.toString()}")
        }else{
            ShowName.setText(sharedNameValue).toString()
            ShowId.setText(sharedIdValue.toString())
        }*/


         button!!.setOnClickListener { galleryIntent() }
         button_logout.setOnClickListener {

         }
     }

     private fun galleryIntent() {
         //alertDialog.let { if (alertDialog.isShowing) alertDialog.dismiss() }
         val galleryIntent = Intent(
             Intent.ACTION_PICK,
             MediaStore.Images.Media.EXTERNAL_CONTENT_URI
         )
         startActivityForResult(galleryIntent, REQUEST_GALLERY)

     }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)
         if (resultCode == Activity.RESULT_OK) {
             if (data != null) {
                 when (requestCode) {
                     // REQUEST_CAMERA -> onCaptureImageResult(data)
                     REQUEST_GALLERY -> onSelectFromGalleryResult(data)
                 }
             }
         }
     }

     private fun onSelectFromGalleryResult(data: Intent?) {
         if (data != null) {

             val imageUri = data.data
             //successProfileURI = imageUri
             //val filePath = RealPathUtil.getRealPath(this@ProfileEditActivity, imageUri)
             val filePath = imageUri?.let { RealPathUtil.getRealPath(this@OnLogin, it) }

             Log.e("Rats File Gallery", filePath)
             Log.e("Rats Gallery", imageUri.toString())
             /*imageUri?.let {
                 Glide.with(applicationContext)
                     .load(it)
                     .apply(RequestOptions.circleCropTransform())
                     .into(iv_profile_pic)
             }
             callUploadService(filePath!!)*/


             val pathHolder: String? = data?.data?.path
             textView!!.text = filePath
         }
     }


    private fun callUploadService(filepath:String) {

        textView?.text

    }

 }
