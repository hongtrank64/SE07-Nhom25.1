package com.example.studentmanagement;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements Login.OnLoginFormActivityListener {

    public static PrefConfig prefConfig;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefConfig = new PrefConfig(this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            if (prefConfig.readLoginStatus()) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, new AfterLogin())
                        .commit();
            }

            else {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, new Login())
                        .commit();
            }
        }
    }

    @Override
    public void performLogin(String studentID) {

        prefConfig.writeName(studentID);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new AfterLogin())
                .commit();

    }

    public void performLogout() {
        prefConfig.writeLoginStatus(false);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new Login())
                .commit();

    }
}