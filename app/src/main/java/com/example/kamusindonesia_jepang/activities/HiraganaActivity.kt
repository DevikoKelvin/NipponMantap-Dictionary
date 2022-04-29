package com.example.kamusindonesia_jepang.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kamusindonesia_jepang.R
import com.example.kamusindonesia_jepang.adapters.HiraganaPagerAdapter
import com.example.kamusindonesia_jepang.databinding.ActivityHiraganaBinding
import com.google.android.material.tabs.TabLayoutMediator

class HiraganaActivity : AppCompatActivity() {

    companion object{
        val tabTitle = intArrayOf(
            R.string.a, R.string.i, R.string.u, R.string.e, R.string.o
        )
    }

    private lateinit var binding : ActivityHiraganaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiraganaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.hiragana)

        binding.viewPager.adapter = HiraganaPagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager)
        { tab, position ->
            tab.text = resources.getString(tabTitle[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }
}