package com.example.motivationquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dlNavDrawer;
    NavigationView nvNavDrawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dlNavDrawer = findViewById(R.id.dlNavDrawer);
        nvNavDrawer = findViewById(R.id.nvNavDrawer);
        toolbar = findViewById(R.id.tbNavDrawer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this, dlNavDrawer, toolbar,
                R.string.openDrawer, R.string.closeDrawer);
        dlNavDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        loadFragment(new CategoryFragment(), 1);
        nvNavDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.itemCategory) {
                    Fragment fragment=new CategoryFragment();

                    loadFragment(fragment,1);
                } else if (id == R.id.itemLatest) {
                    Fragment fragment = new QuotesFragment();
                    loadFragment(fragment, 0);
                } else {
                    finish();
                }
                dlNavDrawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (dlNavDrawer.isDrawerOpen(GravityCompat.START)) {
            dlNavDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.flMainContainer, fragment);
        ft.commit();


    }
}