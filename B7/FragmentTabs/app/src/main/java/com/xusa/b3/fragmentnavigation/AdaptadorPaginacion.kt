package com.xusa.b3.fragmentnavigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdaptadorPaginacion (context: AppCompatActivity):
    FragmentStateAdapter(context)
{
    override fun getItemCount(): Int {
       return 3
    }

    override fun createFragment(position: Int): Fragment {
         return when (position) {
             0 -> Fragment1()
             1 -> Fragment3()
             2 -> Fragment2()
             else ->Fragment1()
         }
     }
}