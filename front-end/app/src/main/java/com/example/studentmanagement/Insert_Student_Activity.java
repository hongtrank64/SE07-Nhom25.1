package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagement.api.ApiClient;
import com.example.studentmanagement.api.ApiInterface;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import Entity.Student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;


public class Insert_Student_Activity extends AppCompatActivity {

    private EditText StudentID, Fullname, Gender, Birth, Address, Classroom, Email, Phone ,GPA;
    private Button btn_Insert;
    private ApiInterface apiInterface_insert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_student);

        StudentID = findViewById(R.id.insert_studentID);
        Fullname = findViewById(R.id.insert_fullname);
        Gender = findViewById(R.id.insert_gender);
        Birth = findViewById(R.id.insert_birth);
        Address = findViewById(R.id.insert_address);
        Classroom = findViewById(R.id.insert_classroom);
        Email = findViewById(R.id.insert_email);
        Phone = findViewById(R.id.insert_phone);
        GPA = findViewById(R.id.insert_gpa);

        btn_Insert = findViewById(R.id.btn_insert);
        btn_Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert_student();

            }
        });


    }

    private void insert_student() {

        String studentID = StudentID.getText().toString();
        String full_name = Fullname.getText().toString();
        String gender = Gender.getText().toString();

        String Birth_date = Birth.getText().toString();
        Date birth = null;
        convertStringToDate(birth, Birth_date);

        String address = Address.getText().toString();
        String classroom = Classroom.getText().toString();
        String email = Email.getText().toString();
        String phone = Phone.getText().toString();

        Float gpa = Float.parseFloat(GPA.getText().toString());

        insert(studentID, full_name, gender, birth,  address, classroom, email, phone, gpa);

    }

    private void insert(String in_studentID, String in_full_name, String in_gender, Date in_birth, String in_address, String in_classroom, String in_email, String in_phone, Float in_gpa){

        in_studentID = StudentID.getText().toString();
        in_full_name = Fullname.getText().toString();
        in_gender = Gender.getText().toString();

        String Birth_date = Birth.getText().toString();
        //in_birth = convertStringToDate(Birth_date);
        convertStringToDate(in_birth, Birth_date);

        in_address = Address.getText().toString();
        in_classroom = Classroom.getText().toString();
        in_email = Email.getText().toString();
        in_phone = Phone.getText().toString();

        in_gpa = Float.parseFloat(GPA.getText().toString());


        apiInterface_insert = ApiClient.getClient().create(ApiInterface.class);
        Call<Student> insertStudent = apiInterface_insert.insert_Student(in_studentID, in_full_name, in_gender, in_birth, in_address, in_classroom, in_email, in_phone, in_gpa);
        insertStudent.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {

                if (response.body().getResponse().equals("ok")) {
                    Toast.makeText(Insert_Student_Activity.this, "Lưu thành công!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Insert_Student_Activity.this, Teacher_Activity.class));
                }
                else {
                    Toast.makeText(Insert_Student_Activity.this,"Đăng kí thất bại", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {

                Toast.makeText(Insert_Student_Activity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Response fail", t.getLocalizedMessage(), t);

            }
        });

    }

    public static Date convertStringToDate(Date date1, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date1 = formatter.parse(format);
            return date1;

        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;

    }


}