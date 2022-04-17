package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class RecycleView extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private Button btTambah;
    private AdapterRV adapter;
    private ArrayList<String> data;
    private static int n = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        recyclerView = findViewById(R.id.recycler_view);

        data = new ArrayList<>();
        data.add("Data " + n++);
        data.add("Data " + n++);
        data.add("Data " + n++);

        adapter = new AdapterRV(data);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecycleView.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        btTambah = findViewById(R.id.btTambah);
        btTambah.setOnClickListener(this);

    }

    public void onClick(View v) {
        data.add("Data " + n++);
        adapter.notifyDataSetChanged();
    }



}