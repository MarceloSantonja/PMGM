package com.marcelo.p2parcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.marcelob2.personalibrary.Persona


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pers = intent.getParcelableExtra<Persona>("PERSONA")

        findViewById<TextView>(R.id.PersonaTextView).setText(pers.toString())


    }
}