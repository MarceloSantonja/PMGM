package com.marcelo.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.marcelo.radiobutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val corporativo =binding.CorporativoLayout
        val particular = binding.ParticularLayout
        val corporativoBoton =binding.CorporativoRadioButton
        val particularBoton = binding.ParticularRadioButton

        binding.GrupoRadioBotones.setOnCheckedChangeListener { radioGrups, entero->

            if (corporativoBoton.isChecked) {
                corporativo.setVisibility(View.VISIBLE)
                particular.setVisibility(View.GONE)
            }
            if (particularBoton.isChecked) {
                corporativo.setVisibility(View.GONE)
                particular.setVisibility(View.VISIBLE)

            }
        }
    }
}