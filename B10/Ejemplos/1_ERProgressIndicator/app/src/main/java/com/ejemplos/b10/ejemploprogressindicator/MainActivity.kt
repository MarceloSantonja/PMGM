package com.example.ejemploprogressindicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.ejemploprogressindicator.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
     var dialog: AlertDialog?=null
    var progressBar: ProgressBar? = null
    var progreso = 0
    lateinit var loadingMessage: TextView
    lateinit var progressMessage: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState!=null) progreso=savedInstanceState.getInt("PROGRESO")
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(progreso>0)  barraProgreso()
        binding.buttonProgress.setOnClickListener {barraProgreso()}
    }

    fun barraProgreso() {
        setDialog()
        CoroutineScope(Dispatchers.Default).launch {
            val inicio = progreso
            for (i in inicio..100) {
                Thread.sleep(100)
                withContext(Dispatchers.Main) {
                    progressBar!!.progress = i
                    progressMessage.text = i.toString() + "/100"
                    progreso = i
                }
            }
            progreso = 0
            dialog?.dismiss()
            dialog = null
        }
    }

    private fun setDialog() {
        val builder = MaterialAlertDialogBuilder(this)
        val inflater = this@MainActivity.layoutInflater
        val v = inflater.inflate(R.layout.dialogo_progress, null)
        progressBar = v.findViewById(R.id.loader)
        loadingMessage = v.findViewById(R.id.loading_msg)
        progressMessage = v.findViewById(R.id.progres_msg)
        builder.setView(v)
        dialog = builder.create()
        dialog?.setCancelable(false)
        dialog?.show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("PROGRESO", progreso)
        if (dialog != null) {
            dialog?.dismiss()
            dialog = null
        }
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        progreso = savedInstanceState.getInt("PROGRESO")
    }

}