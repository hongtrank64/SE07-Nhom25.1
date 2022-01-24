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
        Call<List<Student>> student_list = apiInterface_listStudent.list_Student();
        student_list.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                studentList = response.body();
                if (response.isSuccessful()) {
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

                        TextView list_position = new TextView(List_Student_Teacher_Activity.this);
                        list_position.setTextSize(20);
                        list_position.setGravity(Gravity.CENTER);
                        list_position.setBackgroundResource(R.drawable.border);

                        list_studentID.setText(studentList.get(i).getStudentID());
                        list_fullname.setText(studentList.get(i).getName());
                        list_gender.setText(studentList.get(i).getGender());
                        list_birth.setText(convertDateToString(studentList.get(i).getBirthday(), "dd/MM/YYYY"));
                        list_address.setText(studentList.get(i).getAddress());
                        list_classroom.setText(studentList.get(i).getClassroom());
                        list_email.setText(studentList.get(i).getEmail());
                        list_phone.setText(studentList.get(i).getPhone());
                        list_GPA.setText(String.valueOf(studentList.get(i).getGPA()));

                        int pos = studentList.get(i).getPosition();
                        if (pos == 0) {
                            list_position.setText("Sinh viên");
                        }
                        else if (pos == 1) {
                            list_position.setText("Lớp trưởng");
                        }
                        else if (pos == 2) {
                            list_position.setText("Thủ quỹ");
                        }




                        tableRow.addView(list_studentID);
                        tableRow.addView(list_fullname);
                        tableRow.addView(list_gender);
                        tableRow.addView(list_birth);
                        tableRow.addView(list_address);
                        tableRow.addView(list_classroom);
                        tableRow.addView(list_email);
                        tableRow.addView(list_phone);
                        tableRow.addView(list_GPA);
                        tableRow.addView(list_position);

                        tblayout_listStudent.addView(tableRow);
                    }

                }

                //show the number of students
                TableRow tableRow_count = new TableRow(List_Student_Teacher_Activity.this);
                tableRow_count.setPadding(20,100,10,10);

                TextView count = new TextView(List_Student_Teacher_Activity.this);
                count.setText("Tổng: " + studentList.size() + " sinh viên");
                count.setTextSize(20);
                tableRow_count.addView(count);
                tblayout_listStudent.addView(tableRow_count);

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