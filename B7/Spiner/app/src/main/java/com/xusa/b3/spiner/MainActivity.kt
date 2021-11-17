package com.xusa.b3.spiner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast


class MainActivity : AppCompatActivity(){//}, AdapterView.OnItemSelectedListener {
    lateinit var valores:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        valores =
            arrayOf("item1", "item2", "item3", "item4",
                "item5", "item6", "item7", "item8")
        val spinner=findViewById<Spinner>(R.id.spinner)
        spinner.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,valores)

       spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
           override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               Toast.makeText(this@MainActivity,"Elemento pulsado ${valores.get(p2)}",
                   Toast.LENGTH_SHORT).show()
           }

           override fun onNothingSelected(p0: AdapterView<*>?) {
               TODO("Not yet implemented")
           }

       })


    }

   /* override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(this,"Elemento pulsado ${valores.get(p2)}",
            Toast.LENGTH_SHORT).show()

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }*/
}