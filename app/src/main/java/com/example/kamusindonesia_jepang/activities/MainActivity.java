package com.example.kamusindonesia_jepang.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kamusindonesia_jepang.R;
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

        bind.btnHurufJepang.setOnClickListener(view -> {
            Intent i = new Intent(this, HurufJepangActivity.class);
            startActivity(i);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.nav_about)
        {
            Toast.makeText(this, "about me", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}