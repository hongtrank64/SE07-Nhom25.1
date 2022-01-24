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

import Entity.Event;
import Entity.Student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List_Event_Teacher_Activity extends AppCompatActivity {
    private ApiInterface apiInterface_listEvent;
    private TableLayout tblayout_listEvent;
    private List<Event> eventList;
    private List<Student> selectPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_event);

        tblayout_listEvent = findViewById(R.id.table_list_event);

        apiInterface_listEvent = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Event>> list_Event = apiInterface_listEvent.list_Event();
        list_Event.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()) {
                    eventList = response.body();
                    for (int i = 0; i < eventList.size(); i++) {
                        TableRow tableRow = new TableRow(List_Event_Teacher_Activity.this);
                        tableRow.setPadding(10, 0, 10, 0);

                        TextView ID_event = new TextView(List_Event_Teacher_Activity.this);
                        ID_event.setTextSize(20);
                        ID_event.setGravity(Gravity.CENTER);
                        ID_event.setBackgroundResource(R.drawable.border);

                        TextView event_name = new TextView(List_Event_Teacher_Activity.this);
                        event_name.setTextSize(20);
                        event_name.setGravity(Gravity.CENTER);
                        event_name.setBackgroundResource(R.drawable.border);

                        TextView start = new TextView(List_Event_Teacher_Activity.this);
                        start.setTextSize(20);
                        start.setGravity(Gravity.CENTER);
                        start.setBackgroundResource(R.drawable.border);

                        TextView end = new TextView(List_Event_Teacher_Activity.this);
                        end.setTextSize(20);
                        end.setGravity(Gravity.CENTER);
                        end.setBackgroundResource(R.drawable.border);

                        TextView address = new TextView(List_Event_Teacher_Activity.this);
                        address.setTextSize(20);
                        address.setGravity(Gravity.CENTER);
                        address.setBackgroundResource(R.drawable.border);

                        TextView requirement = new TextView(List_Event_Teacher_Activity.this);
                        requirement.setTextSize(20);
                        requirement.setGravity(Gravity.CENTER);
                        requirement.setBackgroundResource(R.drawable.border);

                        TextView status = new TextView(List_Event_Teacher_Activity.this);
                        status.setTextSize(20);
                        status.setGravity(Gravity.CENTER);
                        status.setBackgroundResource(R.drawable.border);

                        ID_event.setText(eventList.get(i).getEventId());
                        event_name.setText(eventList.get(i).getEventName());
                        start.setText(convertDateToString(eventList.get(i).getTimeStart(), "dd/MM/YYYY"));
                        end.setText(convertDateToString(eventList.get(i).getTimeEnd(), "dd/MM/YYYY"));
                        address.setText(eventList.get(i).getAddress());
                        requirement.setText(String.valueOf(eventList.get(i).getRequirement()));

                        int sts = eventList.get(i).getStatus();
                        if (sts == 0) {
                            status.setText("Bắt buộc");
                        }
                        else status.setText("Tự chọn");

                        tableRow.addView(ID_event);
                        tableRow.addView(event_name);
                        tableRow.addView(start);
                        tableRow.addView(end);
                        tableRow.addView(address);
                        tableRow.addView(requirement);
                        tableRow.addView(status);


                        tblayout_listEvent.addView(tableRow);

                    }
                }

                /*TableRow tableRow_note1 = new TableRow(List_Event_Teacher_Activity.this);
                tableRow_note1.setPadding(15, 200, 10, 0);

                TextView note_1 = new TextView(List_Event_Teacher_Activity.this);
                note_1.setText("* Chú thích: 0 là bắt buộc");
                note_1.setTextSize(20);
                tableRow_note1.addView(note_1);
                tblayout_listEvent.addView(tableRow_note1);

                TableRow tableRow_note2 = new TableRow(List_Event_Teacher_Activity.this);
                tableRow_note2.setPadding(308, 0, 10, 0);

                TextView note_2 = new TextView(List_Event_Teacher_Activity.this);
                note_2.setText("1 là tự chọn");
                note_2.setTextSize(20);
                tableRow_note2.addView(note_2);
                tblayout_listEvent.addView(tableRow_note2);*/

            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Toast.makeText(List_Event_Teacher_Activity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Response fail", t.getLocalizedMessage(), t);

            }
        });
    }

    public static String convertDateToString(Date date, String format) {
        SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat(format);
        return mySimpleDateFormat.format(date);
    }
}