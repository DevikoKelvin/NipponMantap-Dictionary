package com.example.kamusindonesia_jepang.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kamusindonesia_jepang.fragments.*

class HiraganaPagerAdapter(act : AppCompatActivity) :
    FragmentStateAdapter(act)
{
    override fun createFragment(position : Int) : Fragment = when (position)
    {
        0 -> HiraganaAFragment()
        1 -> HiraganaIFragment()
        2 -> HiraganaUFragment()
        3 -> HiraganaEFragment()
        4 -> HiraganaOFragment()
        else -> Fragment()
    }

    override fun getItemCount() : Int = 5
}