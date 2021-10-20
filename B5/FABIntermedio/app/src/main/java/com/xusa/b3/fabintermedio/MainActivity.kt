package com.xusa.b3.fabintermedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Pattern

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val datos= arrayListOf<String>("Como","Cuando","Como estamos")
        val tlf=findViewById<TextInputEditText>(R.id.telefonoText)
        val adaptador=ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,resources.getStringArray(R.array.colores))
        val adaptador2=ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1)
        adaptador2.addAll(datos)

        tlf.setOnLongClickListener{
            if(Patterns.PHONE.matcher(tlf.text.toString()).matches()!=true)
                tlf.error="Telefono Incorrecto"
            true
        }

        findViewById<MaterialAutoCompleteTextView>(R.id.paisText).setAdapter(adaptador2)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener{
         var snackbar=   Snackbar.make(findViewById(R.id.contenedor),"Hola Mundo",
                Snackbar.LENGTH_INDEFINITE)
              snackbar.setAction("Aceptar"){
                val items = arrayOf("item1","item3","item2")
                  MaterialAlertDialogBuilder(this)
                    .setTitle("Mi dialogo")
                    .setMessage("Lorem Ipsum")
                    .setItems(items){ textId,w->

                    }
                    .setNeutralButton("Aceptar"){textID,w ->
                    }.show()



              }
             snackbar.show()
        }

    }
}