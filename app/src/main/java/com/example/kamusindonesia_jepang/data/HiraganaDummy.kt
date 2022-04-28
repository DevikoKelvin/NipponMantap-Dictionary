package com.example.kamusindonesia_jepang.data

import com.example.kamusindonesia_jepang.R

object HiraganaDummy {

    fun generateDummyHiraganaA() : List<HiraganaEntity>{
        val hiraganaA = ArrayList<HiraganaEntity>()

        hiraganaA.add(
            HiraganaEntity(
                "A",
                R.drawable.a,
                "a"
            )
        )

        hiraganaA.add(
            HiraganaEntity(
                "KA",
                R.drawable.ka,
                "ka"
            )
        )

        hiraganaA.add(
            HiraganaEntity(
                "SA",
                R.drawable.sa,
                "sa"
            )
        )

        hiraganaA.add(
            HiraganaEntity(
                "TA",
                R.drawable.ta,
                "ta"
            )
        )

        hiraganaA.add(
            HiraganaEntity(
                "NA",
                R.drawable.na,
                "na"
            )
        )

        hiraganaA.add(
            HiraganaEntity(
                "HA",
                R.drawable.ha,
                "ha"
            )
        )

        hiraganaA.add(
            HiraganaEntity(
                "MA",
                R.drawable.ma,
                "ma"
            )
        )

        hiraganaA.add(
            HiraganaEntity(
                "YA",
                R.drawable.ya,
                "ya"
            )
        )
        return hiraganaA
    }
}