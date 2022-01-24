package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.studentmanagement.api.ApiClient;
import com.example.studentmanagement.api.ApiInterface;

import java.util.List;


import Entity.Student;
import Entity.TrainingScores;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Transcript_Student_Activity extends AppCompatActivity {

    private ApiInterface apiInterface_listTrainingScore, apiInterface_showGPA;
    private TableLayout tblayout_listTrainingScore;
    private List<TrainingScores> trainingScoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transcript_student);

        tblayout_listTrainingScore = findViewById(R.id.table_list_trainingScore);

        String studentID = SharedPref.getInstance(this).LoggedInID(); //studentID

        apiInterface_listTrainingScore = ApiClient.getClient().create(ApiInterface.class);
        Call<List<TrainingScores>> list_TrainingScore = apiInterface_listTrainingScore.list_TrainingScores(studentID);
        list_TrainingScore.enqueue(new Callback<List<TrainingScores>>() {
            @Override
            public void onResponse(Call<List<TrainingScores>> call, Response<List<TrainingScores>> response) {
                if (response.isSuccessful()) {
                    trainingScoreList = response.body();
                    for (int i = 0; i < trainingScoreList.size(); i++) {
                        TableRow tableRow = new TableRow(Transcript_Student_Activity.this);
                        tableRow.setPadding(10, 0, 10, 0);

                        TextView ID_trainingScore = new TextView(Transcript_Student_Activity.this);
                        ID_trainingScore.setTextSize(20);
                        ID_trainingScore.setGravity(Gravity.CENTER);
                        ID_trainingScore.setBackgroundResource(R.drawable.border);

                        TextView year = new TextView(Transcript_Student_Activity.this);
                        year.setTextSize(20);
                        year.setGravity(Gravity.CENTER);
                        year.setBackgroundResource(R.drawable.border);

                        TextView score = new TextView(Transcript_Student_Activity.this);
                        score.setTextSize(20);
                        score.setGravity(Gravity.CENTER);
                        score.setBackgroundResource(R.drawable.border);

                        year.setText(trainingScoreList.get(i).getSem_year());
                        score.setText(String.valueOf(trainingScoreList.get(i).getScores()));

                        tableRow.addView(year);
                        tableRow.addView(score);

                        tblayout_listTrainingScore.addView(tableRow);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<TrainingScores>> call, Throwable t) {

            }
        });

        apiInterface_showGPA = ApiClient.getClient().create(ApiInterface.class);
        Call<Student> showGPA = apiInterface_showGPA.profile_Student(studentID);
        showGPA.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (response.body().getResponse().equals("ok")) {
                    TableRow tableRow_name = new TableRow(Transcript_Student_Activity.this);
                    tableRow_name.setPadding(10,100,30,0);

                    TextView GPA_name = new TextView(Transcript_Student_Activity.this);
                    GPA_name.setText("Điểm tích lũy");
                    GPA_name.setTextSize(20);
                    GPA_name.setGravity(Gravity.CENTER);
                    GPA_name.setBackgroundResource(R.drawable.border);

                    TextView rank_name = new TextView(Transcript_Student_Activity.this);
                    rank_name.setText("Xếp loại");
                    rank_name.setTextSize(20);
                    rank_name.setGravity(Gravity.CENTER);
                    rank_name.setBackgroundResource(R.drawable.border);

                    tableRow_name.addView(GPA_name);
                    tableRow_name.addView(rank_name);

                    tblayout_listTrainingScore.addView(tableRow_name);


                    TableRow tableRow_gpa = new TableRow(Transcript_Student_Activity.this);
                    tableRow_gpa.setPadding(10,0,10,0);

                    TextView GPA = new TextView(Transcript_Student_Activity.this);
                    GPA.setTextSize(20);
                    GPA.setGravity(Gravity.CENTER);
                    GPA.setBackgroundResource(R.drawable.border);

                    TextView rank = new TextView(Transcript_Student_Activity.this);
                    rank.setTextSize(20);
                    rank.setGravity(Gravity.CENTER);
                    rank.setBackgroundResource(R.drawable.border);

                    Float gpa = response.body().getGPA();
                    if ( gpa > 3.60 && gpa < 4.00) {
                        GPA.setText(String.valueOf(gpa));
                        rank.setText("Xuất sắc");
                    }

                    else if (gpa > 3.20 && gpa < 3.59) {
                        GPA.setText(String.valueOf(gpa));
                        rank.setText("Giỏi");
                    }

                    else if (gpa > 2.50 && gpa < 3.19) {
                        GPA.setText(String.valueOf(gpa));
                        rank.setText("Khá");
                    }

                    else if (gpa > 2.00 && gpa < 2.49) {
                        GPA.setText(String.valueOf(gpa));
                        rank.setText("Trung bình");
                    }

                    else {
                        GPA.setText(String.valueOf(gpa));
                        rank.setText("Yếu");
                    }

                    tableRow_gpa.addView(GPA);
                    tableRow_gpa.addView(rank);

                    tblayout_listTrainingScore.addView(tableRow_gpa);
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {

            }
        });


     }
}