package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recycleview.MrHead2;
import com.example.recycleview.ContactUs;
import com.example.recycleview.RecycleView;
import com.example.recycleview.R;

public class Pilihan extends AppCompatActivity implements View.OnClickListener{

    Button head, aboutUs, recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan);

        head = findViewById(R.id.bt_head);
        aboutUs = findViewById(R.id.bt_about);
        recycler = findViewById(R.id.bt_recycler);

        head.setOnClickListener(this);
        aboutUs.setOnClickListener(this);
        recycler.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == head.getId()) {
            Intent intent = new Intent(this, MrHead2.class);
            startActivity(intent);
        } else if (v.getId() == aboutUs.getId()) {
            Intent intent = new Intent(this,ContactUs.class);
            startActivity(intent);
        } else if (v.getId() == recycler.getId()) {
            Intent intent = new Intent(this, RecycleView.class);
            startActivity(intent);
        }
    }
}