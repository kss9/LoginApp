package com.example.loginapp.activities

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.R
import com.nbsp.materialfilepicker.MaterialFilePicker
import com.nbsp.materialfilepicker.ui.FilePickerActivity
import org.jetbrains.annotations.NotNull
import java.util.jar.Manifest
import android.view.View as View1


class OnSuccessLogin : AppCompatActivity() {

    //var button: Button? = null
    //var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_success_login)

        /*if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        }*/

        var button = findViewById(R.id.button) as Button
        var textView = findViewById(R.id.textView) as TextView


        button.setOnClickListener {
            fun onClick(v: View1) {
                MaterialFilePicker()
                    .withActivity(this)
                    .withRequestCode(1000)
                    .withHiddenFiles(true) // Show hidden files and folders
                    .start()

            }

        }


    }


    internal fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH)
            // Do anything with file
        }
    }

   /*fun onRequestPermissionResult(
        requestCode: Int,
        permissions: Array<String?>, @NotNull grantResults: IntArray
    ) {
        when (requestCode) {
            1001 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Permission not granted!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

*/


}
