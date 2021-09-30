package com.marcelob2.intentexplicito

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Actividad2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
        val intento = intent
        findViewById<TextView>(R.id.texto).
            /*setText(intento.getStringExtra("NOMBRE")+
                    intento.getIntExtra("EDAD",0)*/

        setText(
            intento.getStringExtra(("DATO"))
        )

        findViewById<TextView>(R.id.texto).setOnClickListener() {
            val intento = Intent()
            intento.putExtra("DATOS", "soy el resultado!! ")
            setResult(Activity.RESULT_OK, intento)
            finish()

        }


    }
}