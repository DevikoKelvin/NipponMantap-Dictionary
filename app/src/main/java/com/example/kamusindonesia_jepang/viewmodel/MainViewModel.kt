package com.example.kamusindonesia_jepang.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kamusindonesia_jepang.data.HiraganaDummy
import com.example.kamusindonesia_jepang.data.HiraganaEntity

class MainViewModel(app : Application) : AndroidViewModel(app) {

    fun getListHiraganaA() : List<HiraganaEntity> = HiraganaDummy.generateDummyHiraganaA()
}