package com.example.kamusindonesia_jepang.data;

public class Result
{
    private final String indo;
    private final String romaji;
    private final String kanji;
    private final String keterangan;

    public Result(String indo, String romaji, String kanji, String keterangan)
    {
        this.indo = indo;
        this.romaji = romaji;
        this.kanji = kanji;
        this.keterangan = keterangan;
    }

    public String getIndo()
    {
        return indo;
    }

    public String getRomaji()
    {
        return romaji;
    }

    public String getKanji()
    {
        return kanji;
    }

    public String getKeterangan() { return keterangan;}
}
