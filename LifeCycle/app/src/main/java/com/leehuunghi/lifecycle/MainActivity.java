package com.leehuunghi.lifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword, txtRetype, txtBirthdate;
    Button btnReset, btnSignup;
    CheckBox ckbTennis,ckbFutbal,ckbOthers;
    RadioButton btnGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();

    }

    private void setControl() {
        txtUsername=findViewById(R.id.txtUsername);
        txtPassword=findViewById(R.id.txtPassword);
        txtRetype=findViewById(R.id.txtRetype);
        txtBirthdate=findViewById(R.id.txtBirthdate);
        btnReset=findViewById(R.id.btnReset);
        btnSignup=findViewById(R.id.btnSignup);
        ckbTennis=findViewById(R.id.ckbTennis);
        ckbFutbal=findViewById(R.id.ckbFutball);
        ckbOthers=findViewById(R.id.ckbOthers);
    }


}

