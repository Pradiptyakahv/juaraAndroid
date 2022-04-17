package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.recycleview.ContactUs;
import com.example.recycleview.R;

public class MrHead2 extends AppCompatActivity implements View.OnClickListener{

    ImageView hair;
    ImageView moustache;
    ImageView eyebrow;
    ImageView beard;
    Button _ContactUs, _back;
    CheckBox cbHair;
    CheckBox cbMoustache;
    CheckBox cbEyebrow;
    CheckBox cbBeard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mr_head2);

        hair = findViewById(R.id.atrRambut);
        moustache = findViewById(R.id.atrKumis);
        eyebrow = findViewById(R.id.atrAlis);
        beard = findViewById(R.id.atrJanggut);
        _ContactUs = findViewById(R.id.btcontact);
        _back = findViewById(R.id.btback);
        cbHair = findViewById(R.id.checkBoxRambut);
        cbMoustache = findViewById(R.id.checkBoxKumis);
        cbEyebrow = findViewById(R.id.checkBoxAlis);
        cbBeard = findViewById(R.id.checkBoxJanggut);

        cbHair.setChecked(true);
        cbMoustache.setChecked(true);
        cbEyebrow.setChecked(true);
        cbBeard.setChecked(true);

        _ContactUs.setOnClickListener(this);
        _back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==_ContactUs.getId())
        {
            Intent it = new Intent(this, ContactUs.class);
            startActivity(it);
        }
        if(v.getId()==_back.getId())
        {
            finish();
        }
    }

    public void checkClicked(View v) {
        // Save which checkbox was clicked, and save the text and its current checked state
        CheckBox checkbox = (CheckBox) v;
        String text = checkbox.getText().toString();
        boolean checked = checkbox.isChecked();

        String rambut = "Rambut";
        if (text.equals(rambut)) {
            if (checked) {
                hair.setVisibility(View.VISIBLE);
            } else {
                hair.setVisibility(View.INVISIBLE);
            }
        }

        String kumis = "Kumis";
        if (text.equals(kumis)) {
            if (checked) {
                moustache.setVisibility(View.VISIBLE);
            } else {
                moustache.setVisibility(View.INVISIBLE);
            }
        }

        String alis = "Alis";
        if (text.equals(alis)) {
            if (checked) {
                eyebrow.setVisibility(View.VISIBLE);
            } else {
                eyebrow.setVisibility(View.INVISIBLE);
            }
        }

        String janggut = "Janggut";
        if (text.equals(janggut)) {
            if (checked) {
                beard.setVisibility(View.VISIBLE);
            } else {
                beard.setVisibility(View.INVISIBLE);
            }
        }
    }
}