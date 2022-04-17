package com.example.recycleview;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycleview.Pilihan;
import com.example.recycleview.R;
import com.example.recycleview.Register;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button _btLogin;
    TextView _btReg;
    EditText _txEmail, _txPassword;
    String _tempEmail = "";
    String _tempPassword = "";
    String _tempNama = "";
    int reqCode = 99;
    ActivityResultLauncher<Intent> registerResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        _tempNama = data.getStringExtra("nama");
                        _tempEmail = data.getStringExtra("email");
                        _tempPassword = data.getStringExtra("password");
                        _txEmail.setText(_tempEmail);
                        _txPassword.setText(_tempPassword);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btLogin = findViewById(R.id.btSave);
        _btReg = findViewById(R.id.btRegister);
        _txEmail = findViewById(R.id.txEmail);
        _txPassword = findViewById(R.id.txPW);

        _btLogin.setOnClickListener(this);
        _btReg.setOnClickListener(this);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Check which request we're responding to
//        if (requestCode == reqCode) {
//            //make sure the request was successful
//            if (resultCode == RESULT_OK) {
//                _tempEmail = data.getStringExtra("email");
//                _txEmail.setText(_tempEmail);
//            }
//        }
//    }

    @Override
    public void onClick(View v) {

        if (v.getId() == _btLogin.getId()) {
            if (_tempEmail.equals(_txEmail.getText().toString()) && _tempPassword.equals(_txPassword.getText().toString()) && _tempEmail != "") {
                Intent intent = new Intent(this, Pilihan.class);
                startActivity(intent);
            } else if (_tempEmail.equals(_txEmail.getText().toString()) && !_tempPassword.equals(_txPassword.getText().toString()) && _tempPassword != "") {
                Toast.makeText(this, "password salah", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "email salah", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == _btReg.getId()) {
            Intent intentB = new Intent(this, Register.class);
            registerResultLauncher.launch(intentB);
//            Intent intentB  = new Intent(this, Register.class);
//
//            // put some data
//            intentB.putExtra("asal", 99);
//
//            this.startActivityForResult(intentB, reqCode);

        }

    }
}