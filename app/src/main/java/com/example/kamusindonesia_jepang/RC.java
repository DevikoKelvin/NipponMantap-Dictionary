package com.example.kamusindonesia_jepang;

public class RC
{
    char[] pattern, kalimat;
    int[][] rcBc = new int[256][256];
    int[] rcGs = new int[256];
    int[] h = new int[256];
    int[] kmin = new int[256];

    public RC(String X)
    {
        pattern = X.toLowerCase().toCharArray();
        int[] locc = new int[256];
        int[] link = new int[256];
        int[] hmin = new int[256];
        int[] rmin = new int[256];
        int a, i, j, k, q, r = 0, s, m = pattern.length;
        /* Computation of link and locc */
        for (a = 0; a < 256; ++a)
            locc[a] = -1;
        link[0] = -1;
        for (i = 0; i < m - 1; ++i)
        {
            link[i + 1] = locc[pattern[i]];
            locc[pattern[i]] = i;
        }

        /* Computation of rcBc */
        for (a = 0; a < 256; ++a)
            for (s = 1; s <= m; ++s)
            {
                i = locc[a];
                j = link[m - s];
                while (i - j != s && j >= 0)
                    if (i - j > s)
                        i = link[i + 1];
                    else
                        j = link[j + 1];
                while (i - j > s)
                    i = link[i + 1];
                rcBc[a][s] = m - i - 1;
            }

        /* Computation of hmin */
        k = 1;
        i = m - 1;
        while (k <= m)
        {
            while (i - k >= 0 && pattern[i - k] == pattern[i])
                --i;
            hmin[k] = i;
            q = k + 1;
            while (hmin[q - k] - (q - k) > i)
            {
                hmin[q] = hmin[q - k];
                ++q;
            }
            i += (q - k);
            k = q;
            if (i == m)
                i = m - 1;
        }

        /* Computation of kmin */
        for (a = 0; a < 256; ++a)
            kmin[a] = 0;

        for (k = m; k > 0; --k)
            kmin[hmin[k]] = k;

        /* Computation of rmin */
        for (i = m - 1; i >= 0; --i)
        {
            if (hmin[i + 1] == i)
                r = i + 1;
            rmin[i] = r;
        }

        /* Computation of rcGs */
        i = 1;
        for (k = 1; k <= m; ++k)
            if (hmin[k] != m - 1 && kmin[hmin[k]] == k)
            {
                h[i] = hmin[k];
                rcGs[i++] = k;
            }
        i = m - 1;
        for (j = m - 2; j >= 0; --j)
            if (kmin[j] == 0)
            {
                h[i] = j;
                rcGs[i--] = rmin[j];
            }
        rcGs[m] = rmin[0];
    }

    boolean cari(String Y)
    {
        int m = pattern.length;
        int i, j = 0;
        int s = m;

        kalimat = Y.toLowerCase().toCharArray();

        while (j <= kalimat.length - m)
        {
            while (j <= kalimat.length - m && pattern[m - 1] != kalimat[j + m - 1])
            {
                s = rcBc[kalimat[j + m - 1]][s];
                j += s;
            }
            i = 1;
            try
            {
                for (i = 1; i < m && pattern[h[i]] == kalimat[j + h[i]]; ++i) ;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            if (j <= kalimat.length - m && i >= m)
                return true;

            s = rcGs[i];
            j += s;
        }
        return false;
    }
}

