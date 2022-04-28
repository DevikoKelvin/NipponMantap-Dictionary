package com.example.kamusindonesia_jepang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.kamusindonesia_jepang.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        bind.btnIndJpn.setOnClickListener(view -> {
            Intent i = new Intent(this, IndToJpnActivity.class);
            startActivity(i);
        });

        bind.btnJpnInd.setOnClickListener(view -> {
            Intent i = new Intent(this, JpnToIndActivity.class);
            startActivity(i);
        });

        
    }
}