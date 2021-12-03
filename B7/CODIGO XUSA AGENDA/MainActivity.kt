package com.example.agenda20_21

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.example.agenda20_21.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val pagerAdapter = FragmentPageAdapter(this)
        binding.ViewPager.adapter = pagerAdapter
    }

    override fun onBackPressed() {
        if ( binding.ViewPager.currentItem == 0)  super.onBackPressed()
        else  binding.ViewPager.currentItem = binding.ViewPager.currentItem - 1
    }


}





