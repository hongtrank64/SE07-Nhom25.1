package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentmanagement.api.ApiClient;
import com.example.studentmanagement.api.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Entity.Student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List_Student_Teacher_Activity extends AppCompatActivity {

    private TableLayout tblayout_listStudent;
    private ApiInterface apiInterface_listStudent;
    private List<Student> studentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student_teacher);

        tblayout_listStudent = findViewById(R.id.table_list_student);


        apiInterface_listStudent = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Student>> student_list = apiInterface_listStudent.list_Student_teacher();
        student_list.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if (response.isSuccessful()) {
                    studentList = response.body();
                    for (int i = 0; i < studentList.size(); i++) {
                        TableRow tableRow = new TableRow(List_Student_Teacher_Activity.this);
                        tableRow.setPadding(10,0,10,0);

                        TextView list_studentID = new TextView(List_Student_Teacher_Activity.this);
                        list_studentID.setTextSize(20);
                        list_studentID.setGravity(Gravity.CENTER);
                        list_studentID.setBackgroundResource(R.drawable.border);


                        TextView list_fullname = new TextView(List_Student_Teacher_Activity.this);
                        list_fullname.setTextSize(20);
                        list_fullname.setGravity(Gravity.CENTER);
                        list_fullname.setBackgroundResource(R.drawable.border);

                        TextView list_gender = new TextView(List_Student_Teacher_Activity.this);
                        list_gender.setTextSize(20);
                        list_gender.setGravity(Gravity.CENTER);
                        list_gender.setBackgroundResource(R.drawable.border);

                        TextView list_birth = new TextView(List_Student_Teacher_Activity.this);
                        list_birth.setTextSize(20);
                        list_birth.setGravity(Gravity.CENTER);
                        list_birth.setBackgroundResource(R.drawable.border);

                        TextView list_address = new TextView(List_Student_Teacher_Activity.this);
                        list_address.setTextSize(20);
                        list_address.setGravity(Gravity.CENTER);
                        list_address.setBackgroundResource(R.drawable.border);

                        TextView list_classroom = new TextView(List_Student_Teacher_Activity.this);
                        list_classroom.setTextSize(20);
                        list_classroom.setGravity(Gravity.CENTER);
                        list_classroom.setBackgroundResource(R.drawable.border);

                        TextView list_email = new TextView(List_Student_Teacher_Activity.this);
                        list_email.setTextSize(20);
                        list_email.setGravity(Gravity.CENTER);
                        list_email.setBackgroundResource(R.drawable.border);

                        TextView list_phone = new TextView(List_Student_Teacher_Activity.this);
                        list_phone.setTextSize(20);
                        list_phone.setGravity(Gravity.CENTER);
                        list_phone.setBackgroundResource(R.drawable.border);

                        TextView list_GPA = new TextView(List_Student_Teacher_Activity.this);
                        list_GPA.setTextSize(20);
                        list_GPA.setGravity(Gravity.CENTER);
                        list_GPA.setBackgroundResource(R.drawable.border);

                        list_studentID.setText(studentList.get(i).getStudentID());
                        list_fullname.setText(studentList.get(i).getName());
                        list_gender.setText(studentList.get(i).getGender());
                        list_birth.setText(convertDateToString(studentList.get(i).getBirthday(), "dd/MM/YYYY"));
                        list_address.setText(studentList.get(i).getAddress());
                        list_classroom.setText(studentList.get(i).getClassroom());
                        list_email.setText(studentList.get(i).getEmail());
                        list_phone.setText(studentList.get(i).getPhone());
                        list_GPA.setText(String.valueOf(studentList.get(i).getGPA()));



                        tableRow.addView(list_studentID);
                        tableRow.addView(list_fullname);
                        tableRow.addView(list_gender);
                        tableRow.addView(list_birth);
                        tableRow.addView(list_address);
                        tableRow.addView(list_classroom);
                        tableRow.addView(list_email);
                        tableRow.addView(list_phone);
                        tableRow.addView(list_GPA);

                        tblayout_listStudent.addView(tableRow);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Toast.makeText(List_Student_Teacher_Activity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Response fail", t.getLocalizedMessage(), t);

            }
        });
    }

    public static String convertDateToString (Date date, String format) {
        SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat(format);
        return mySimpleDateFormat.format(date);
    }
}