package com.example.admin.week03;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class registerform extends AppCompatActivity {

    EditText txtUsername, txtPassword, txtRetype, txtBirthdate;
    RadioButton radMale, radFemale;
    CheckBox chkTennis, chkFutbal, chkOthers;
    Button btnReset, btnSignup, btnSelect;
    Calendar calendar=Calendar.getInstance();
    SimpleDateFormat birthdate=new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLySelect();
            }
        });
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

    private void xuLySelect() {
        DatePickerDialog.OnDateSetListener callback=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,date);
                txtBirthdate.setText(birthdate.format(calendar.getTime()));
            }
        };
        DatePickerDialog df=new DatePickerDialog
                (registerform.this,
                        callback,
               calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
       df.show();
    }

    private void xuLySignup() {
        if (xuLyNhapDu()==true) {
            if (xuLyRetype()==true && xuLyBirthdate()==true) {
                Intent intent = new Intent(registerform.this, resultform.class);

                intent.putExtra("username", txtUsername.getText().toString());
                intent.putExtra("password", txtPassword.getText().toString());
                intent.putExtra("birthdate", txtBirthdate.getText().toString());
                String gender = "";
                if (radMale.isChecked()==true) {
                    gender += radMale.getText().toString();
                }
                if (radFemale.isChecked()==true) {
                    gender += radFemale.getText().toString();
                }
                intent.putExtra("gender", gender);
                String hobbies = "";
                int flag = 0;
                if (chkTennis.isChecked()==true) {
                    flag = 1;
                    hobbies += chkTennis.getText().toString();
                }
                if (chkFutbal.isChecked()==true) {
                    if (flag == 1) {
                        hobbies += ", " + chkFutbal.getText().toString();
                    } else {
                        flag = 1;
                        hobbies += chkFutbal.getText().toString();
                    }

                }
                if (chkOthers.isChecked()==true) {
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
    }

    private boolean xuLyNhapDu() {
        if (txtUsername.getText().toString() == "" || txtPassword.getText().toString() == "" || txtBirthdate.getText().toString() == ""
                || txtRetype.getText().toString() == "" || (radMale.isChecked() == false && radFemale.isChecked() == false)
                || (chkTennis.isChecked() == false && chkFutbal.isChecked() == false && chkOthers.isChecked() == false)) {
            Toast.makeText(registerform.this, "Vui lòng điền đủ thông tin!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean xuLyBirthdate() {
        String S=txtBirthdate.getText().toString();

        birthdate.setLenient(false);
        try{
            birthdate.parse(S);
        }
        catch (ParseException e)
        {
            Toast.makeText(registerform.this,"Ngày sinh không đúng định dạng\nVui lòng nhập lại!",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean xuLyRetype() {
        if (txtPassword.getText().toString().equals(txtRetype.getText().toString())==false)
        {
            Toast.makeText(registerform.this,"Mật khẩu không khớp, vui lòng nhập lại!",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
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
        txtUsername= (EditText) findViewById(R.id.txtUsername);
        txtPassword=(EditText) findViewById(R.id.txtPassword);
        txtRetype=(EditText) findViewById(R.id.txtRetype);
        txtBirthdate= (EditText) findViewById(R.id.txtBirthdate);

        radMale= (RadioButton) findViewById(R.id.radMale);
        radFemale=(RadioButton) findViewById(R.id.radFemale);

        chkTennis= (CheckBox) findViewById(R.id.chkTennis);
        chkFutbal=(CheckBox) findViewById(R.id.chkFutbal);
        chkOthers= (CheckBox) findViewById(R.id.chkOthers);

        btnReset= (Button) findViewById(R.id.btnReset);
        btnSignup= (Button) findViewById(R.id.btnSignup);
        btnSelect= (Button) findViewById(R.id.btnSelect);

        calendar=Calendar.getInstance();

    }

}
