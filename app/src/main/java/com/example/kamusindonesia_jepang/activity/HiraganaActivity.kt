package com.example.kamusindonesia_jepang.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kamusindonesia_jepang.R
import com.example.kamusindonesia_jepang.adapter.SectionPagerAdapter
import com.example.kamusindonesia_jepang.databinding.ActivityHiraganaBinding
import com.google.android.material.tabs.TabLayoutMediator

class HiraganaActivity : AppCompatActivity() {

    companion object{
        private val tabTitle = intArrayOf(
            R.string.a, R.string.i
        )
    }

    private lateinit var binding : ActivityHiraganaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiraganaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.hiragana)

        binding.viewPager.adapter = SectionPagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager)
        { tab, position ->
            tab.text = resources.getString(tabTitle[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }
}