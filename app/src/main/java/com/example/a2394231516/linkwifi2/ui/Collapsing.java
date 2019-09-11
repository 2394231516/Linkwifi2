package com.example.a2394231516.linkwifi2.ui;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a2394231516.linkwifi2.R;
import com.example.a2394231516.linkwifi2.adapter.RecycleAdapter;

public class Collapsing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing);
        collapsingToolbarLayout.setTitle("试试看 ");
        RecyclerView recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new RecycleAdapter(getApplicationContext()));
    }
}
