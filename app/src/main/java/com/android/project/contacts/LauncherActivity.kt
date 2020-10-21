package com.android.project.contacts

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.android.project.contacts.databinding.ActivityLauncherBinding

class LauncherActivity: AppCompatActivity() {
    val PERMISSION_REQUEST_CODE = 100
    lateinit var binding:ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_launcher)
        checkPermission(Manifest.permission.READ_CONTACTS, PERMISSION_REQUEST_CODE)
    }

    fun checkPermission(permission: String, requestCode: Int) {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        }else{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == PERMISSION_REQUEST_CODE){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //permissions granted
                binding.progressBar.progress = 100
                _startActivity<MainActivity>()
            }
            else {
                //basically looping in again to ask permission for now
                checkPermission(Manifest.permission.READ_CONTACTS, PERMISSION_REQUEST_CODE)
            }
        }
    }
}