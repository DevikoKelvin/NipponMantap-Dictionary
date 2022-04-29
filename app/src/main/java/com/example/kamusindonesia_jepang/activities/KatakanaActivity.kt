package com.example.kamusindonesia_jepang.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kamusindonesia_jepang.databinding.ActivityKatakanaBinding

class KatakanaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityKatakanaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKatakanaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}