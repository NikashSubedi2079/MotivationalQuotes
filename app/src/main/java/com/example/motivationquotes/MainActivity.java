package com.example.motivationquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        for category one
        findViewById(R.id.CatOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainQuotesActivity.class);
                intent.putExtra("category","CatOne");
                startActivity(intent);
            }
        });

//        for category two
        findViewById(R.id.CatTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainQuotesActivity.class);
                intent.putExtra("category","CatTwo");
                startActivity(intent);
            }
        });

//        category three
        findViewById(R.id.CatThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainQuotesActivity.class);
                intent.putExtra("category","CatThree");
                startActivity(intent);
            }
        });

//        category four
        findViewById(R.id.CatFour).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainQuotesActivity.class);
                intent.putExtra("category","CatFour");
                startActivity(intent);
            }
        });
// for cat five
        findViewById(R.id.CatFive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainQuotesActivity.class);
                intent.putExtra("category","CatFive");
                startActivity(intent);
            }
        });

        findViewById(R.id.CatSix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainQuotesActivity.class);
                intent.putExtra("category","CatSix");
                startActivity(intent);
            }
        });

        findViewById(R.id.CatSeven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainQuotesActivity.class);
                intent.putExtra("category","CatSeven");
                startActivity(intent);
            }
        });

        findViewById(R.id.CatEight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainQuotesActivity.class);
                intent.putExtra("category","CatEight");
                startActivity(intent);
            }
        });


    }
}