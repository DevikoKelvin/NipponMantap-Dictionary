package com.example.kamusindonesia_jepang.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class HiraganaEntity (
    val id: String,
    val imgPoster: Int,
    val description: String
) : Parcelable