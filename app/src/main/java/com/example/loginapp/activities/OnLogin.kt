package com.example.loginapp.activities


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.R
import com.example.loginapp.utility.RealPathUtil


class OnLogin : AppCompatActivity() {

     private var button: Button? = null
     private var textView: TextView? = null
     private val REQUEST_GALLERY =1


    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_on_login)

         button = findViewById<View>(R.id.button) as Button
         textView = findViewById<View>(R.id.textView) as TextView

         button!!.setOnClickListener { galleryIntent() }

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
