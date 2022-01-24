package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.studentmanagement.api.ApiClient;
import com.example.studentmanagement.api.ApiInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import Entity.Student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class Insert_Student_Activity extends AppCompatActivity {

    private EditText StudentID, Fullname, Gender, Birth, Address, Classroom, Email, Phone ,GPA, Position;
    private Button btn_Insert;
    private ApiInterface apiInterface_insert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_student);

        initUI();

        //button insert student
        btn_Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert_student();

            }
        });

    }

    private void initUI() {

        StudentID = findViewById(R.id.insert_studentID);
        Fullname = findViewById(R.id.insert_fullname);
        Gender = findViewById(R.id.insert_gender);
        Birth = findViewById(R.id.insert_birth);
        Address = findViewById(R.id.insert_address);
        Classroom = findViewById(R.id.insert_classroom);
        Email = findViewById(R.id.insert_email);
        Phone = findViewById(R.id.insert_phone);
        GPA = findViewById(R.id.insert_gpa);

        Position = findViewById(R.id.insert_position);

        btn_Insert = findViewById(R.id.btn_insert);

    }


    private void insert_student() {

        String studentID = StudentID.getText().toString();
        String full_name = Fullname.getText().toString();
        String gender = Gender.getText().toString();

        String birth = Birth.getText().toString();

        String address = Address.getText().toString();
        String classroom = Classroom.getText().toString();
        String email = Email.getText().toString();
        String phone = Phone.getText().toString();

        Float gpa = Float.parseFloat(GPA.getText().toString());
        Integer position = Integer.valueOf(Position.getText().toString());


        insert(studentID, full_name, gender, birth,  address, classroom, email, phone, gpa, position);

    }

    private void insert(String in_studentID, String in_full_name, String in_gender, String in_birth, String in_address, String in_classroom, String in_email, String in_phone, Float in_gpa, int in_position){

        in_studentID = StudentID.getText().toString();
        in_full_name = Fullname.getText().toString();
        in_gender = Gender.getText().toString();

        in_birth = Birth.getText().toString();

        in_address = Address.getText().toString();
        in_classroom = Classroom.getText().toString();
        in_email = Email.getText().toString();
        in_phone = Phone.getText().toString();

        in_gpa = Float.parseFloat(GPA.getText().toString());

        in_position = Integer.parseInt(Position.getText().toString());

        apiInterface_insert = ApiClient.getClient().create(ApiInterface.class);
        Call<Student> insertStudent = apiInterface_insert.insert_Student(in_studentID, in_full_name, in_gender, in_birth, in_address, in_classroom, in_email, in_phone, in_gpa, in_position);
        insertStudent.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {

                if (response.body().getResponse().equals("ok")) {
                    Toast.makeText(Insert_Student_Activity.this, "Lưu thành công!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Insert_Student_Activity.this, Teacher_Activity.class));
                }
                else {
                    Toast.makeText(Insert_Student_Activity.this,"Lưu thất bại", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {

                Toast.makeText(Insert_Student_Activity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Response fail", t.getLocalizedMessage(), t);

            }
        });

    }

    /*public static Date convertStringToDate(String string) {
        //string 2001/06/23
        String year = "";
        String month = "";
        String day = "";
        for (int i = 0; i < 4; i++) {
            year = year + string.charAt(i);
        }
        for (int i = 5; i < 7; i++) {
            month = month + string.charAt(i);
        }
        for (int i = 8; i < 10; i++) {
            day = day + string.charAt(i);
        }
        Date date = new Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
        return date; //date = 2001-06-23

    }*/


}