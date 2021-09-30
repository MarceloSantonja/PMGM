package com.marcelob2.intentexplicito

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val openPostActivity =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    Toast.makeText(
                        applicationContext, result.data?.getStringExtra("DATOS"), Toast.LENGTH_SHORT
                    ).show()
                }
            }
        findViewById<Button>(R.id.boton).setOnClickListener()
        {
            openPostActivity.launch(
                Intent(applicationContext, Actividad2::class.java).apply
                { putExtra("DATO", "Este es el valor que se manda desde Main Activity") })
        }
        /*
        findViewById<Button>(R.id.boton).setOnClickListener()
        {
            val intento = Intent(applicationContext,Actividad2::class.java)
            intento.putExtra("NOMBRE","PEPE")
            intento.putExtra("EDAD",15)
            startActivity(intento)

        }

         */
    }
}