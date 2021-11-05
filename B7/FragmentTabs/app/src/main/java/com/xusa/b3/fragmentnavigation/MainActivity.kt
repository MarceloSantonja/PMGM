package com.xusa.b3.fragmentnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewPager=findViewById<ViewPager2>(R.id.contenedor)
        viewPager.adapter=AdaptadorPaginacion(this)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.tabMode=TabLayout.MODE_SCROLLABLE

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.setIcon(R.drawable.ic_launcher_background)
                1 -> {
                    tab.text="Tap 2"
                    tab.setIcon(R.drawable.ic_launcher_foreground)
                }
                2 -> tab.setIcon(R.drawable.ic_launcher_foreground)
            }
        }.attach()




    }
}