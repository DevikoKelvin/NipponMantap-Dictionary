package com.example.kamusindonesia_jepang.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.kamusindonesia_jepang.R
import com.example.kamusindonesia_jepang.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binds: ActivitySplashScreenBinding
    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    companion object
    {
        private const val delay: Long = 2000
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binds = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binds.root)
        //Animation
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        binds.apply {
            logo.animation = topAnimation
            txtLogo.animation = bottomAnimation
        }

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(
                    Intent(
                        this@SplashScreenActivity,
                        MainActivity::class.java
                    )
                )
                finish()
            },
            delay
        )
    }
}