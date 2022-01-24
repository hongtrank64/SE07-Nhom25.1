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
    private Button btnReg_Student, btn_Insert, btn_List_Student, btn_Funds, btn_Event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_teacher);

       initUI();


        if (!SharedPref.getInstance(this).isLoggedIn()) {
            startActivity(new Intent(this, LogInActivity.class));
            finish();
        }

        String loggedName = SharedPref.getInstance(this).LoggedInUser();
        name.setText(loggedName);

        //button logout
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                SharedPref.getInstance(getApplicationContext()).LogOut();
            }
        });

        //button register student
        btnReg_Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Signup_Activity.class);
                startActivity(intent);
            }
        });

        // button insert student
        btn_Insert = findViewById(R.id.ínsert_student);
        btn_Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Insert_Student_Activity.class));
            }
        });

        //button list student
        btn_List_Student = findViewById(R.id.list_student);
        btn_List_Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), List_Student_Teacher_Activity.class));
            }
        });

        btn_Funds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Funds_Teacher_Activity.class));
            }
        });

        btn_Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), List_Event_Teacher_Activity.class));
            }
        });
    }

    //anh xa
    private void initUI() {

        name = findViewById(R.id.name_teacher);

        btnExit = findViewById(R.id.btn_dangxuat);
        btnReg_Student = findViewById(R.id.reg_student);
        btn_Funds = findViewById(R.id.funds);
        btn_Event = findViewById(R.id.event);
    }


}