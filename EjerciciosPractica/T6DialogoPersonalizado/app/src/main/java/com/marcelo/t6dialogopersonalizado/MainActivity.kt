package com.marcelo.t6dialogopersonalizado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.forEach
import androidx.core.view.iterator
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.marcelo.t6dialogopersonalizado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val singleItems = arrayOf("Item 1", "Item 2", "Item 3")
        val checkedItem = 1
        binding.root.forEach { view ->
            if (view is MaterialButton) {
                view.setOnClickListener { v ->
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Dialogo")
                        .setMessage("pulsaste el botón ${view.text}")
                        .setNeutralButton("cancel") { dialog, which ->
                        }
                        .setPositiveButton("ok") { dialog, which ->
                        }
                        .show()
                }
            }
        }


// button1 y dialogo no existen en el ejemplo
/*        binding.button1.setOnClickListener( ){
            val al = createLoginDialogo()
            al.show()
        }*/
    }

/*    private fun createLoginDialogo(): MaterialAlertDialogBuilder {
        val builder = MaterialAlertDialogBuilder(this@MainActivity)
        val inflater = this@MainActivity.layoutInflater
        val v = inflater.inflate(R.layout.dialogo, null)

    }*/


}