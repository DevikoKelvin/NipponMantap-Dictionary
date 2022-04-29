package com.example.kamusindonesia_jepang.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kamusindonesia_jepang.fragments.*

class KatakanaPagerAdapter (act : AppCompatActivity) :
    FragmentStateAdapter(act)
{
    override fun createFragment(position : Int) : Fragment = when (position)
    {
        0 -> KatakanaAFragment()
        1 -> KatakanaIFragment()
        2 -> KatakanaUFragment()
        3 -> KatakanaEFragment()
        4 -> KatakanaOFragment()
        else -> Fragment()
    }

    override fun getItemCount() : Int = 5
}