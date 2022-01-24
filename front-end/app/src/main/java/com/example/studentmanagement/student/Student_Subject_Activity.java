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

import java.util.List;

import Entity.Subject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Student_Subject_Activity extends AppCompatActivity {

    private TableLayout tblayout_listSubject;
    private ApiInterface apiInterface_listSubject;
    private List<Subject> subjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_subject);

        tblayout_listSubject = findViewById(R.id.table_list_subject);

        String studentID = SharedPref.getInstance(this).LoggedInID();

        apiInterface_listSubject = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Subject>> list_Subject = apiInterface_listSubject.list_Subject(studentID);
        list_Subject.enqueue(new Callback<List<Subject>>() {
            @Override
            public void onResponse(Call<List<Subject>> call, Response<List<Subject>> response) {
                if (response.isSuccessful()) {
                    subjectList = response.body();
                    for (int i = 0; i < subjectList.size(); i++) {
                        TableRow tableRow = new TableRow(Student_Subject_Activity.this);
                        tableRow.setPadding(10,0,10,0);

                        TextView ID_subject = new TextView(Student_Subject_Activity.this);
                        ID_subject.setTextSize(20);
                        ID_subject.setGravity(Gravity.CENTER);
                        ID_subject.setBackgroundResource(R.drawable.border);

                        TextView subject_name = new TextView(Student_Subject_Activity.this);
                        subject_name.setTextSize(20);
                        subject_name.setGravity(Gravity.CENTER);
                        subject_name.setBackgroundResource(R.drawable.border);

                        TextView credit = new TextView(Student_Subject_Activity.this);
                        credit.setTextSize(20);
                        credit.setGravity(Gravity.CENTER);
                        credit.setBackgroundResource(R.drawable.border);

                        TextView name_teacher = new TextView(Student_Subject_Activity.this);
                        name_teacher.setTextSize(20);
                        name_teacher.setGravity(Gravity.CENTER);
                        name_teacher.setBackgroundResource(R.drawable.border);

                        TextView room = new TextView(Student_Subject_Activity.this);
                        room.setTextSize(20);
                        room.setGravity(Gravity.CENTER);
                        room.setBackgroundResource(R.drawable.border);

                        TextView day = new TextView(Student_Subject_Activity.this);
                        day.setTextSize(20);
                        day.setGravity(Gravity.CENTER);
                        day.setBackgroundResource(R.drawable.border);

                        TextView start = new TextView(Student_Subject_Activity.this);
                        start.setTextSize(20);
                        start.setGravity(Gravity.CENTER);
                        start.setBackgroundResource(R.drawable.border);

                        TextView end = new TextView(Student_Subject_Activity.this);
                        end.setTextSize(20);
                        end.setGravity(Gravity.CENTER);
                        end.setBackgroundResource(R.drawable.border);

                        ID_subject.setText(subjectList.get(i).getSubjectCode());
                        subject_name.setText(subjectList.get(i).getSubjectTitle());
                        credit.setText(String.valueOf(subjectList.get(i).getCredits()));
                        name_teacher.setText(subjectList.get(i).getTeacherName());
                        room.setText(subjectList.get(i).getRoom());
                        day.setText(subjectList.get(i).getDay());
                        start.setText(String.valueOf(subjectList.get(i).getTimeStart()));
                        end.setText(String.valueOf(subjectList.get(i).getTimeEnd()));

                        tableRow.addView(ID_subject);
                        tableRow.addView(subject_name);
                        tableRow.addView(credit);
                        tableRow.addView(name_teacher);
                        tableRow.addView(room);
                        tableRow.addView(day);
                        tableRow.addView(start);
                        tableRow.addView(end);

                        tblayout_listSubject.addView(tableRow);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Subject>> call, Throwable t) {

            }
        });


    }

}