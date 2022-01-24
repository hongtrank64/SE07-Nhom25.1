package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Teacher_Activity extends AppCompatActivity {

    private TextView name;
    private Button btnExit;
    private Button btnReg_Student, btn_Insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_teacher);

        name = findViewById(R.id.name_teacher);
        btnExit = findViewById(R.id.btn_dangxuat);


        if (!SharedPref.getInstance(this).isLoggedIn()) {
            startActivity(new Intent(this, LogInActivity.class));
            finish();
        }

        String loggedName = SharedPref.getInstance(this).LoggedInUser();
        name.setText(loggedName);


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                SharedPref.getInstance(getApplicationContext()).LogOut();
            }
        });

        btnReg_Student = findViewById(R.id.reg_student);
        btnReg_Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Signup_Activity.class);
                startActivity(intent);
            }
        });

        btn_Insert = findViewById(R.id.ínsert_student);
        btn_Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Insert_Student_Activity.class));
            }
        });



    }


}