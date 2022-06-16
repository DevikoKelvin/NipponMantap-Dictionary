package com.example.kamusindonesia_jepang.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kamusindonesia_jepang.R
import com.example.kamusindonesia_jepang.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.about);
    }
}