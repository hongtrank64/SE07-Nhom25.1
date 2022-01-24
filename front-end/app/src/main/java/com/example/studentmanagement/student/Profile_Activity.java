package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagement.api.ApiClient;
import com.example.studentmanagement.api.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.Date;

import Entity.Student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile_Activity extends AppCompatActivity {

    private ApiInterface apiInterface_Profile, apiInterface_Update;
    private EditText  ID, Fullname, Gender, Birthday, Address, Class_room, Email, Phone, GPA;
    private Button btn_Update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ID = findViewById(R.id.pro_studentid);
        Fullname = findViewById(R.id.pro_fullname);
        Gender = findViewById(R.id.pro_gender);
        Birthday = findViewById(R.id.pro_birth);
        Address = findViewById(R.id.pro_address);
        Class_room = findViewById(R.id.pro_classroom);
        Email = findViewById(R.id.pro_email);
        Phone = findViewById(R.id.pro_phone);
        GPA = findViewById(R.id.pro_gpa);


        String loggedID = SharedPref.getInstance(this).LoggedInID();

        apiInterface_Profile = ApiClient.getClient().create(ApiInterface.class);
        Call<Student> profileStudent = apiInterface_Profile.profile_Student(loggedID);
        profileStudent.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (response.body().getResponse().equals("ok")) {

                    ID.setText(response.body().getStudentID());
                    Fullname.setText(response.body().getName());
                    Gender.setText(response.body().getGender());

                    //chuyển Date -> String
                    Birthday.setText(convertDateToString(response.body().getBirthday(), "dd/MM/YYYY"));

                    Address.setText(response.body().getAddress());
                    Class_room.setText(response.body().getClassroom());
                    Email.setText(response.body().getEmail());
                    Phone.setText(response.body().getPhone());
                    GPA.setText(String.valueOf(response.body().getGPA()));

                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(Profile_Activity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Response fail", t.getLocalizedMessage(), t);

            }
        });

        btn_Update = findViewById(R.id.btn_update);
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Update();
            }
        });

    }

    private void Update() {

        String studentID = SharedPref.getInstance(this).LoggedInID();
        String address = Address.getText().toString();
        String email = Email.getText().toString();
        String phone = Phone.getText().toString();

        update(studentID, address, email, phone);


    }

    private void update(String studentID, String address, String email, String phone) {

        studentID = SharedPref.getInstance(this).LoggedInID();
        address = Address.getText().toString();
        email = Email.getText().toString();
        phone = Phone.getText().toString();

        apiInterface_Update = ApiClient.getClient().create(ApiInterface.class);
        Call<Student> studentCall = apiInterface_Update.update_Student(studentID, address, email, phone);
        studentCall.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {

                if (response.body().getResponse().equals("ok")) {
                    Toast.makeText(Profile_Activity.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Profile_Activity.this, "Cập nhật thất bại", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(Profile_Activity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Response fail", t.getLocalizedMessage(), t);

            }
        });
    }

    public static String convertDateToString(Date date, String format) {
        SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat(format);
        return mySimpleDateFormat.format(date);
    }
}
