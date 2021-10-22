package com.xusa.b3.botones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.xusa.b3.botones.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener, MaterialButtonToggleGroup.OnButtonCheckedListener{

    lateinit var bindig:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        bindig.progreso.hide()
        bindig.boton.setOnClickListener{p->
            Toast.makeText(applicationContext,"Boton",Toast.LENGTH_LONG).show()
        }
        bindig.toggleGroup.addOnButtonCheckedListener{group, checkedId, isChecked ->
        }
        bindig.boton0.setOnClickListener(this)
        bindig.botonIcon.setOnClickListener(this)
        bindig.botonUnElevate.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0)
        {
            bindig.boton0->   sacarDialog()
            bindig.botonIcon ->  sacarProgresIndicator()
            bindig.botonUnElevate->  sacarCalendario()
        }
    }

    private fun sacarCalendario() {

        val calendar= Calendar.getInstance()
        calendar.set(1990,4,28)
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setSelection(calendar.timeInMillis)
            .build()

            datePicker.show(supportFragmentManager,"Calendario")
        datePicker.addOnPositiveButtonClickListener {
            calendar.timeInMillis = it
           // Toast.makeText(applicationContext, datePicker.headerText    , Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext, calendar.get(Calendar.DAY_OF_MONTH).toString() +"/"+
                    (calendar.get(Calendar.MONTH)+1)+"/"+
                    calendar.get(Calendar.YEAR)   , Toast.LENGTH_LONG).show()
        }
    }

    fun miPulsacion(v:View)
    {
        Toast.makeText(applicationContext,"´ñlfkjádslkfa´sñdflkñ´dsae",Toast.LENGTH_LONG).show()

    }

    fun sacarDialog()
    {

       val vista= layoutInflater.inflate(R.layout.dialogo_personalizado,null)
       var dialog= MaterialAlertDialogBuilder(this)
        dialog.setView(vista)
        dialog.show()
        vista.findViewById<Button>(R.id.eliminar).setOnClickListener{
            Toast.makeText(applicationContext,"Eliminado!!!",Toast.LENGTH_LONG).show()

        }

    }
    fun sacarProgresIndicator()
    {
        bindig.progreso.show()
    }

    override fun onButtonChecked(
        group: MaterialButtonToggleGroup?,
        checkedId: Int,
        isChecked: Boolean
    ) {
        TODO("Not yet implemented")
    }
}
