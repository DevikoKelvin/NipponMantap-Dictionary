package com.example.kamusindonesia_jepang.algorithms;

public class BR
{
    char[] pattern, kalimat;
    int[][] brBc = new int[512][512];
    int a, b, i;

    public BR(String X)
    {

        pattern = X.toLowerCase().toCharArray();

        for (a = 0; a < brBc.length; ++a)
        {
            for (b = 0; b < brBc.length; ++b)
            {
                brBc[a][b] = pattern.length + 2;
            }
        }
        for (a = 0; a < brBc.length; ++a)
        {
            brBc[a][pattern[0]] = pattern.length + 1;
        }
        for (i = 0; i < pattern.length - 1; ++i)
        {
            brBc[pattern[i]][pattern[i + 1]] = pattern.length - i;
        }
        for (a = 0; a < brBc.length; ++a)
        {
            brBc[pattern[pattern.length - 1]][a] = 1;
        }
    }

    public boolean find(String Y)
    {
        kalimat = Y.toLowerCase().toCharArray();
        int n = kalimat.length;
        int j = 0;
        char[] y = new char[n + brBc.length];
        char c = y[j + pattern.length];
        char d = y[j + pattern.length + 1];


        y[n + 1] = '\0';
        while (j <= n - pattern.length)
        {
            boolean benar = true;
            for (int i = 0; i < pattern.length; i++)
                if (kalimat[i + j] != pattern[i])
                {
                    benar = false;
                    break;
                }
            if (benar) return true;
            j += brBc[c][d];
        }
        return false;
    }
}