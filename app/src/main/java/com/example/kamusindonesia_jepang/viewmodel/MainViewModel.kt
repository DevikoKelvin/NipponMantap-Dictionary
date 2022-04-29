package com.example.kamusindonesia_jepang.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kamusindonesia_jepang.data.HiraganaDummy
import com.example.kamusindonesia_jepang.data.HurufEntity
import com.example.kamusindonesia_jepang.data.KatakanaDummy

class MainViewModel(app : Application) : AndroidViewModel(app) {

    fun getListHiraganaA() : List<HurufEntity> = HiraganaDummy.generateDummyHiraganaA()
    fun getListHiraganaI() : List<HurufEntity> = HiraganaDummy.generateDummyHiraganaI()
    fun getListHiraganaU() : List<HurufEntity> = HiraganaDummy.generateDummyHiraganaU()
    fun getListHiraganaE() : List<HurufEntity> = HiraganaDummy.generateDummyHiraganaE()
    fun getListHiraganaO() : List<HurufEntity> = HiraganaDummy.generateDummyHiraganaO()

    fun getListKatakanaA() : List<HurufEntity> = KatakanaDummy.generateDummyKatakanaA()
    fun getListKatakanaI() : List<HurufEntity> = KatakanaDummy.generateDummyKatakanaI()
    fun getListKatakanaU() : List<HurufEntity> = KatakanaDummy.generateDummyKatakanaU()
    fun getListKatakanaE() : List<HurufEntity> = KatakanaDummy.generateDummyKatakanaE()
    fun getListKatakanaO() : List<HurufEntity> = KatakanaDummy.generateDummyKatakanaO()
}