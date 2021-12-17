package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterLogInActivity extends AppCompatActivity {

    private TextView studentID;
    private Button bntLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_log_in);

        //studentID = findViewById(R.id.studentID);

        //check if user is logged in
        if (!SharedPref.getInstance(this).isLoggedIn()) {
            startActivity(new Intent(this, LogInActivity.class));
            finish();
        }

        //đăng nhập tên người dùng
        String loggedUsename = SharedPref.getInstance(this).LoggedInUser();
        studentID.setText(loggedUsename);

        //bntLogOut = findViewById(R.id.btnDiNgu);
        bntLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                SharedPref.getInstance(getApplicationContext()).LogOut();
            }
        });




    }
}