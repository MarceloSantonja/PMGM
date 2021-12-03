package com.example.agenda20_21

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.ejemplos.b7.myapplication.ItemViewModel
import com.example.agenda20_21.databinding.LayoutEditContactBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class FragmentEditarContacto: Fragment(), View.OnClickListener {

    private var _binding:LayoutEditContactBinding? = null
    private val binding get() = _binding!!
    private val model: ItemViewModel by activityViewModels()
    private lateinit var resultadoCamara: ActivityResultLauncher<Intent>
    private lateinit var resultadoGaleria: ActivityResultLauncher<Intent>
    lateinit  var registerPermisosTomarFoto:ActivityResultLauncher<String>
    lateinit  var registerPermisosStorage:ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerPermisosTomarFoto= registerForActivityResult(ActivityResultContracts.RequestPermission())
        {
            if(it ==true) tomarFoto()
        }
        registerPermisosStorage= registerForActivityResult(ActivityResultContracts.RequestPermission())
        {
            if(it ==true) tomarGaleria()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = LayoutEditContactBinding.inflate(inflater, container, false)
        val nameObserver = Observer<Contacto>{contacto ->  rellenarContacto(contacto)}
        model.getItem.observe(requireActivity(), nameObserver)

        binding.imagen.setOnClickListener {
            registerPermisosTomarFoto.launch(Manifest.permission.CAMERA)
        }
        binding.imagen.setOnLongClickListener {
            registerPermisosStorage.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            true
        }
        binding.fab.setOnClickListener(this)
        creaContratos()
        return binding.root
    }

    override fun onClick(view: View) {
        if (view.getId() === R.id.fab)
            if (chequearEntrada()) guardarContacto(crearContacto())
    }

    private fun rellenarContacto(contacto: Contacto) {
        binding.nombreText.setText(contacto.nombre)
        binding.apellidosText.setText(contacto.apellido)
        binding.tlfText.setText(contacto.telefono)
        binding.mailText.setText(contacto.email)
        binding.imagen.setImageBitmap(contacto.foto)
        binding.checkFamilia.setChecked(contacto.familiar==true)
        binding.checkAmigos.setChecked(contacto.amigos==true)
        binding.checkTrabajo.setChecked(contacto.trabajo==true)
    }

    private fun crearContacto(): Contacto {
        val contacto = Contacto()
        contacto.nombre=binding.nombreText.text.toString()
        contacto.apellido=binding.apellidosText.text.toString()
        contacto.email=binding.mailText.text.toString()
        contacto.telefono=binding.tlfText.text.toString()
        val bmdrawable =  binding.imagen.drawable?.let{it as BitmapDrawable}
        contacto.foto = bmdrawable?.bitmap
        contacto.familiar=binding.checkFamilia.isChecked()
        contacto.amigos=binding.checkAmigos.isChecked()
        contacto.trabajo=binding.checkTrabajo.isChecked()
        return contacto
    }

    private fun guardarContacto(contacto: Contacto) {
        contacto?.let { it ->
            model.setItem(it)
            requireActivity().getSupportFragmentManager().popBackStack()
        }
    }


    private fun chequearEntrada(): Boolean {
        if (!binding.nombreText.text.toString().isEmpty() && !binding.tlfText.text.toString().isEmpty()) {
            if (binding.checkAmigos.isChecked() || binding.checkFamilia.isChecked() || binding.checkTrabajo.isChecked()) return true
            else Snackbar.make(binding.root, "Como mínimo el contacto debe pertenecer a un grupo",BaseTransientBottomBar.LENGTH_LONG).show()
        } else Snackbar.make(binding.root,"Como mínimo el contacto debe tener nombre y telefono", BaseTransientBottomBar.LENGTH_LONG).show()
        return false
    }

    fun tomarFoto(){
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultadoCamara.launch(cameraIntent,)
    }
    fun tomarGaleria(){
        val cameraIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        resultadoGaleria.launch(cameraIntent)
    }
    fun creaContratos ()
    {
        resultadoCamara =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK)
                    binding.imagen.setImageBitmap(result.data?.extras?.get("data") as Bitmap)
            }
        resultadoGaleria =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK)
                    binding.imagen.setImageURI(result.data?.data)
            }
    }
}
