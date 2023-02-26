package com.example.motivationquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvQoutes;
    ArrayList<model> arrayModel;
    DatabaseReference databaseReference;
    QuotesAdapter quotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvQoutes = findViewById(R.id.rvQoutes);


        databaseReference = FirebaseDatabase.getInstance().getReference("quotes");
        rvQoutes.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        arrayModel=new ArrayList<>();

        quotesAdapter=new QuotesAdapter(MainActivity.this,arrayModel);
        rvQoutes.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        rvQoutes.setAdapter(quotesAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    model quote = dataSnapshot.getValue(model.class);
                    boolean add = arrayModel.add(quote);
                }
                quotesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("DATABASE_ERROR", "error");
                System.out.println("error is" + error);
            }


        });
    }
}