package com.ejemplos.b10.ejemploviewmodelcorrutinas


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fM: FragmentManager = supportFragmentManager
        val fT: FragmentTransaction = fM.beginTransaction()
        fT.add(R.id.fragment_uno, FragmentSecundario())
        fT.commit()
    }
}