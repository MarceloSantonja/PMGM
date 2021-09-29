package com.marcelo.a3actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val openPostActivity =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            {
                    result -> if(result.resultCode == RESULT_OK){
                Toast.makeText(applicationContext,
                    "Vengo de: " + result.data?.getStringExtra("DATORETURN"),
                    Toast.LENGTH_SHORT).show()
            }
            }
        findViewById<Button>(R.id.activity2 ).setOnClickListener(
            View.OnClickListener{
                openPostActivity.launch(
                    Intent(applicationContext, Activity2::class.java).apply
                    {putExtra("DATO", "Este valor es el que se manda desde main a la actividad 2")})
            })
        findViewById<Button>(R.id.activity1 ).setOnClickListener(
            View.OnClickListener{
                openPostActivity.launch(
                    Intent(applicationContext, Activity1::class.java).apply
                    {putExtra("DATO", "Este valor es el que se manda desde main a la actividad 1")})
            })


    }
}