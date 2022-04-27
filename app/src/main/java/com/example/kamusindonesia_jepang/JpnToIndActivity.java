package com.example.kamusindonesia_jepang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JpnToIndActivity extends AppCompatActivity
{
    private ResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpn_to_ind);

        setTitle(R.string.jpn_ind);
        setTitleColor(R.color.white);

        adapter = new ResultAdapter();

        TextInputLayout tilKeyword = findViewById(R.id.til_keyword);
        EditText tieKeyword = tilKeyword.getEditText();
        Button searchBerryBtn = findViewById(R.id.btn_search);
        Button searchRcBtn = findViewById(R.id.btn_search2);
        RecyclerView resultRv = findViewById(R.id.rv_result);

        searchBerryBtn.setOnClickListener(view ->
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

        searchRcBtn.setOnClickListener(view ->
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

        resultRv.setAdapter(adapter);
        resultRv.setLayoutManager(new LinearLayoutManager(this));
        resultRv.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
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
            BR berryRavindran = new BR(keyword);

            while ((nextLine = reader.readNext()) != null)
            {
                if (berryRavindran.find(nextLine[1]))
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