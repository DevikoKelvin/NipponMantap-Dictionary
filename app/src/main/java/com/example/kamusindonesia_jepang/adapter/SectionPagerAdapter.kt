package com.example.kamusindonesia_jepang.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kamusindonesia_jepang.fragment.HiraganaAFragment
import com.example.kamusindonesia_jepang.fragment.HiraganaIFragment

class SectionPagerAdapter(act : AppCompatActivity) :
    FragmentStateAdapter(act)
{
    override fun createFragment(position : Int) : Fragment = when (position)
    {
        0 -> HiraganaAFragment()
        1 -> HiraganaIFragment()
        else -> Fragment()
    }

    override fun getItemCount() : Int = 2
}