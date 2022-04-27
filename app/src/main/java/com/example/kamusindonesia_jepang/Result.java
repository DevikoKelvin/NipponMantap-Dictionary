package com.example.kamusindonesia_jepang;

public class Result
{
    private final String word;
    private final String translate;
    private final String desc;

    public Result(String word, String translate, String desc)
    {
        this.word = word;
        this.translate = translate;
        this.desc = desc;
    }

    public String getWord()
    {
        return word;
    }

    public String getTranslate()
    {
        return translate;
    }

    public String getDesc()
    {
        return desc;
    }
}
