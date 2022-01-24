package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Student_Activity extends AppCompatActivity {

    private TextView name;
    private Button btnExit, btnList, btnProfile, btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_student);

        name = findViewById(R.id.fullname);
        btnExit = findViewById(R.id.btndangxuat);

        if (!SharedPref.getInstance(this).isLoggedIn()) {
            startActivity(new Intent(this, LogInActivity.class));
            finish();
        }

        String loggedName = SharedPref.getInstance(this).LoggedInUser(); // username
        String loggedID = SharedPref.getInstance(this).LoggedInID(); //studentID

        name.setText(loggedName + "\n" + loggedID);


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                SharedPref.getInstance(getApplicationContext()).LogOut();
            }
        });

        btnList = findViewById(R.id.btndanhsach);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
                startActivity(i);
            }
        });

        btnProfile = findViewById(R.id.profile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Profile_Activity.class));
            }
        });



    }
}
