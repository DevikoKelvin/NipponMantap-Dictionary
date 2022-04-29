package com.example.kamusindonesia_jepang.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kamusindonesia_jepang.R
import com.example.kamusindonesia_jepang.adapters.HiraganaPagerAdapter
import com.example.kamusindonesia_jepang.adapters.KatakanaPagerAdapter
import com.example.kamusindonesia_jepang.databinding.ActivityKatakanaBinding
import com.google.android.material.tabs.TabLayoutMediator

class KatakanaActivity : AppCompatActivity() {

    companion object{
        private val tabTitle = intArrayOf(
            R.string.a, R.string.i, R.string.u, R.string.e, R.string.o
        )
    }

    private lateinit var binding : ActivityKatakanaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKatakanaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.katakana)

        binding.viewPager.adapter = KatakanaPagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager)
        { tab, position ->
            tab.text = resources.getString(HiraganaActivity.tabTitle[position])
        }.attach()

        supportActionBar?.elevation = 0f

    }
}