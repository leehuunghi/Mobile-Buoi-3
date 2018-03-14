package com.example.admin.week03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword, txtRetype, txtBirthdate;
    RadioButton radMale, radFemale;
    CheckBox chkTennis, chkFutbal, chkOthers;
    Button btnReset, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyReset();
            }
        });
        
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLySignup();
            }
        });
    }

    private void xuLySignup() {
        if (txtUsername.getText().toString() == "" || txtPassword.getText().toString() == "" || txtBirthdate.getText().toString() == ""
                || txtRetype.getText().toString() == "" || (radMale.isChecked() == false && radFemale.isChecked() == false)
                || (chkTennis.isChecked() == false && chkFutbal.isChecked() == false && chkOthers.isChecked() == false)) {
            Toast.makeText(MainActivity.this,"Vui lòng điền đủ thông tin!",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);

            intent.putExtra("username", txtUsername.getText().toString());
            intent.putExtra("password", txtPassword.getText().toString());
            intent.putExtra("birthdate", txtBirthdate.getText().toString());
            String gender = "";
            if (radMale.isChecked()) {
                gender += radMale.getText().toString();
            }
            if (radFemale.isChecked()) {
                gender += radFemale.getText().toString();
            }
            intent.putExtra("gender", gender);
            String hobbies = "";
            int flag = 0;
            if (chkTennis.isChecked()) {
                flag = 1;
                hobbies += chkTennis.getText().toString();
            }
            if (chkFutbal.isChecked()) {
                if (flag == 1) {
                    hobbies += ", " + chkFutbal.getText().toString();
                } else {
                    flag = 1;
                    hobbies += chkFutbal.getText().toString();
                }

            }
            if (chkOthers.isChecked()) {
                if (flag == 1) {
                    hobbies += ", " + chkOthers.getText().toString();
                } else {
                    hobbies += chkOthers.getText().toString();
                }

            }
            intent.putExtra("hobbies", hobbies);

            startActivityForResult(intent, 64);
        }
    }

    private void xuLyReset() {
        txtUsername.setText("");
        txtPassword.setText("");
        txtRetype.setText("");
        txtBirthdate.setText("");

        radMale.setChecked(false);
        radFemale.setChecked(false);

        chkTennis.setChecked(false);
        chkFutbal.setChecked(false);
        chkOthers.setChecked(false);
    }

    private void addControls() {
        txtUsername=findViewById(R.id.txtUsername);
        txtPassword=findViewById(R.id.txtPassword);
        txtRetype=findViewById(R.id.txtRetype);
        txtBirthdate=findViewById(R.id.txtBirthdate);

        radMale=findViewById(R.id.radMale);
        radFemale=findViewById(R.id.radFemale);

        chkTennis=findViewById(R.id.chkTennis);
        chkFutbal=findViewById(R.id.chkFutbal);
        chkOthers=findViewById(R.id.chkOthers);

        btnReset=findViewById(R.id.btnReset);
        btnSignup=findViewById(R.id.btnSignup);
    }

}
