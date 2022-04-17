package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{

    Button _btSave;
    EditText _email, _password, _nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _btSave = findViewById(R.id.btSave);
        _nama = findViewById(R.id.txNama);
        _email = findViewById((R.id.txEmail));
        _password = findViewById(R.id.txPW);

        _btSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // create result data as Intent
        Intent resultIntent = new Intent(); //atau getIntent()
        resultIntent.putExtra("nama", _nama.getText().toString());
        resultIntent.putExtra("email", _email.getText().toString());
        resultIntent.putExtra("password", _password.getText().toString());

        // set result status
        setResult(RESULT_OK, resultIntent);

        // end current Activity
        // and return to calling Activity
        finish();
    }
}