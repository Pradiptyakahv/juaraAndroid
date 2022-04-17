package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity implements View.OnClickListener{

    TextView _notelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        _notelp = findViewById(R.id.txNotelp);
        _notelp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==_notelp.getId())
        {

//            Uri uri = Uri.parse("tel:081358049918");
            Uri uri2 = Uri.parse("tel:"+_notelp.getText().toString());

            Intent it = new Intent(Intent.ACTION_DIAL, uri2);
            startActivity(it);

        }

    }
}