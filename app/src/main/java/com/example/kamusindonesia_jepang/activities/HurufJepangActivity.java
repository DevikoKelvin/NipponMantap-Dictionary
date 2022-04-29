package com.example.kamusindonesia_jepang.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.kamusindonesia_jepang.databinding.ActivityHurufJepangBinding;

public class HurufJepangActivity extends AppCompatActivity {

    private ActivityHurufJepangBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityHurufJepangBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        bind.btnHiragana.setOnClickListener(view -> {
            Intent i = new Intent(this, HiraganaActivity.class);
            startActivity(i);
        });
        bind.btnKatakana.setOnClickListener(view -> {
            Intent i = new Intent(this, KatakanaActivity.class);
            startActivity(i);
        });

    }
}