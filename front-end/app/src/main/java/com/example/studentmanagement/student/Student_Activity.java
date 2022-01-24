package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Student_Activity extends AppCompatActivity {

    private TextView name;
    private Button btnExit, btnProfile, btnListStudent, bntListSubject, btnListEvent, btnListScore, btnFunds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_student);

        initUI();

        if (!SharedPref.getInstance(this).isLoggedIn()) {
            startActivity(new Intent(this, LogInActivity.class));
            finish();
        }

        String loggedName = SharedPref.getInstance(this).LoggedInUser();
        String loggedID = SharedPref.getInstance(this).LoggedInID();

        name.setText(loggedName + "\n" + loggedID);

        //button logout
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                SharedPref.getInstance(getApplicationContext()).LogOut();
            }
        });

        //button profile
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Profile_Activity.class));
            }
        });

        //button list student
        btnListStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Student_List_Activity.class));
            }
        });

        //button list subject
        bntListSubject = findViewById(R.id.listSubject);
        bntListSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Student_Subject_Activity.class));
            }
        });

        //button list event
        btnListEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), List_Event_Activity.class));
            }
        });

        //button score
        btnListScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Transcript_Student_Activity.class));
            }
        });

        //button funds
        btnFunds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Funds_Activity.class));
            }
        });




    }

    //anh xa
    private void initUI() {

        name = findViewById(R.id.fullname);

        btnExit = findViewById(R.id.btndangxuat);
        btnFunds = findViewById(R.id.funds);
        btnListScore = findViewById(R.id.listScore);
        btnListEvent = findViewById(R.id.listEvent);
        btnListStudent = findViewById(R.id.listStudent);
        btnProfile = findViewById(R.id.profile);

    }
}