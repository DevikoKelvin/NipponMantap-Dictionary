package com.example.kamusindonesia_jepang.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kamusindonesia_jepang.data.HiraganaDummy
import com.example.kamusindonesia_jepang.data.HiraganaEntity

class MainViewModel(app : Application) : AndroidViewModel(app) {

    fun getListHiraganaA() : List<HiraganaEntity> = HiraganaDummy.generateDummyHiraganaA()
    fun getListHiraganaI() : List<HiraganaEntity> = HiraganaDummy.generateDummyHiraganaI()
    fun getListHiraganaU() : List<HiraganaEntity> = HiraganaDummy.generateDummyHiraganaU()
    fun getListHiraganaE() : List<HiraganaEntity> = HiraganaDummy.generateDummyHiraganaE()
    fun getListHiraganaO() : List<HiraganaEntity> = HiraganaDummy.generateDummyHiraganaO()
}