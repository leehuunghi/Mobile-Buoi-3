package com.example.admin.week03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtUsername,txtPassword,txtBirthdate,txtGender,txtHobbies;
    Button btnExit;
    Intent intent;
    String username, password,birthdate,gender,hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
    }

    private void addControls() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        txtBirthdate = findViewById(R.id.txtBirthdate);
        txtGender = findViewById(R.id.txtGender);
        txtHobbies = findViewById(R.id.txtHobbies);
        btnExit = findViewById(R.id.btnExit);

        intent = getIntent();
        username=intent.getStringExtra("username");
        password=intent.getStringExtra("password");
        birthdate=intent.getStringExtra("birthdate");
        gender=intent.getStringExtra("gender");
        hobbies=intent.getStringExtra("hobbies");

        txtUsername.setText(username);
        String pass="";
        for (int i=0;i<password.length();i++)
        {
            pass+='*';
        }
        txtPassword.setText(pass);
        txtBirthdate.setText(birthdate);
        txtGender.setText(gender);
        txtHobbies.setText(hobbies);
    }
}
