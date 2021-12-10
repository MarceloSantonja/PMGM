package com.xusa.b9.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var drawerLayout:DrawerLayout
    lateinit  var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawerLayout=findViewById(R.id.drawerLayout)
        var toolbar=findViewById<MaterialToolbar>(R.id.topAppBar)
        var navigation=findViewById<NavigationView>(R.id.navigation)

        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(this, drawerLayout,
            toolbar, R.string.navigation_open,
            R.string.navigation_close)


        val pop=findViewById<TextView>(R.id.texto3)
        pop.setOnClickListener{
            val menuPopUp=PopupMenu(this,pop)
            menuPopUp.inflate(R.menu.opciones_menu)
            menuPopUp.show()
            menuPopUp.setOnMenuItemClickListener {
                when(it.itemId)
                {
                    R.id.option_1 -> Toast.makeText(this,"Opcion1",Toast.LENGTH_SHORT).show()
                    R.id.option_2 -> Toast.makeText(this,"Opcion2",Toast.LENGTH_SHORT).show()
                }
                true
            }
        }
        navigation.setNavigationItemSelectedListener (this)
        registerForContextMenu(findViewById(R.id.texto1))
        registerForContextMenu(findViewById(R.id.texto2))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        var s=""
        when (id) {
            R.id.nav_home -> s="HOME"
            R.id.nav_gallery-> s="GALLERY"
            R.id.nav_slideshow-> s="SLIDESHOW"
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        Toast.makeText(applicationContext,"Pulsaste la opción "+s,
            Toast.LENGTH_SHORT).show()
        return true
    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }
    override fun onConfigurationChanged(newConfig: android.content.
    res.Configuration) {
        if (newConfig != null) {
            super.onConfigurationChanged(newConfig)
        }
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        when(v?.id)
        {
            R.id.texto1 ->menuInflater.inflate(R.menu.opciones_menu,menu)
            R.id.texto2 ->menuInflater.inflate(R.menu.menu2,menu)
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.option_1 -> Toast.makeText(this,"Opcion1",Toast.LENGTH_SHORT).show()
            R.id.option_2 -> Toast.makeText(this,"Opcion2",Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.opciones_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.option_1 -> Toast.makeText(this,"Opcion1",Toast.LENGTH_SHORT).show()
            R.id.option_2 -> Toast.makeText(this,"Opcion2",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}