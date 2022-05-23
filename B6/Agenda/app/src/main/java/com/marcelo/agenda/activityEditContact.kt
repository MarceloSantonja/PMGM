package com.marcelo.agenda

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.marcelo.agenda.databinding.LayoutAddNewContactBinding
import com.marcelo.agenda.databinding.LayoutEditContactBinding
import java.util.zip.Inflater

class activityEditContact : AppCompatActivity() {



    /*cuando pulsemos sobre la imagen nos permitirá seleccionar una imagen de la
galería.
     */
    private lateinit var binding: LayoutEditContactBinding
    private lateinit var resultadoGaleria: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_edit_contact)
        binding = LayoutEditContactBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }


}
