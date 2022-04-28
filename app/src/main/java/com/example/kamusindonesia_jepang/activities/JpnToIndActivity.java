package com.example.kamusindonesia_jepang.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.kamusindonesia_jepang.algorithms.BR;
import com.example.kamusindonesia_jepang.R;
import com.example.kamusindonesia_jepang.algorithms.RC;
import com.example.kamusindonesia_jepang.data.Result;
import com.example.kamusindonesia_jepang.adapters.ResultAdapter;
import com.example.kamusindonesia_jepang.databinding.ActivityJpnToIndBinding;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JpnToIndActivity extends AppCompatActivity
{
    private ResultAdapter adapter;
    private ActivityJpnToIndBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        bind = ActivityJpnToIndBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        setTitle(R.string.jpn_ind);

        adapter = new ResultAdapter();

        EditText tieKeyword = bind.tilKeyword.getEditText();

        bind.btnSearch.setOnClickListener(view ->
        {
            String keyword;

            if (tieKeyword != null)
            {
                keyword = tieKeyword.getText().toString();
                if (!keyword.isEmpty())
                {
                    getBrDataFromExcel(keyword);
                }
            }
        });

        bind.btnSearch2.setOnClickListener(view ->
        {
            String keyword;

            if (tieKeyword != null)
            {
                keyword = tieKeyword.getText().toString();

                if (!keyword.isEmpty())
                {
                    getRcDataFromExcel(keyword);
                }
            }
        });

        bind.rvResult.setAdapter(adapter);
        bind.rvResult.setLayoutManager(new LinearLayoutManager(this));
        bind.rvResult.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
    }

    private void getBrDataFromExcel(String keyword)
    {
        try
        {
            InputStream is = getAssets().open("source.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            reader.readNext();

            String[] nextLine;
            ArrayList<Result> results = new ArrayList<>();

            Long startTime = System.currentTimeMillis();
            BR BR = new BR(keyword);

            while ((nextLine = reader.readNext()) != null)
            {
                if (BR.find(nextLine[1]))
                {
                    Result result = new Result(
                            nextLine[1], nextLine[0], nextLine[2]
                    );

                    results.add(result);
                }
            }

            Long endTime = System.currentTimeMillis();

            Toast.makeText(
                    this,
                    getString(R.string.br_done, endTime - startTime, results.size()),
                    Toast.LENGTH_SHORT
            ).show();

            adapter.setData(results);
        }
        catch (IOException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void getRcDataFromExcel(String keyword)
    {
        try
        {
            InputStream is = getAssets().open("source.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            reader.readNext();

            String[] nextLine;
            ArrayList<Result> results = new ArrayList<>();

            Long startTime = System.currentTimeMillis();
            RC RC = new RC(keyword);

            while ((nextLine = reader.readNext()) != null)
            {
                if (RC.cari(nextLine[1]))
                {
                    Result result = new Result(
                            nextLine[1], nextLine[0], nextLine[2]
                    );

                    results.add(result);
                }
            }

            Long endTime = System.currentTimeMillis();

            Toast.makeText(
                    this,
                    getString(R.string.rc_done, endTime - startTime, results.size()),
                    Toast.LENGTH_SHORT
            ).show();

            adapter.setData(results);
        }
        catch (IOException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}