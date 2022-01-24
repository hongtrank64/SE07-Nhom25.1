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

import Entity.Event;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;


public class Insert_Event_Activity extends AppCompatActivity {

    private EditText EventID, EventName, TimeStart, TimeEnd, Address, Requirement, Status;
    private Button btn_insertEvent;
    private ApiInterface apiInterface_insertEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_event);

        initUI();

        btn_insertEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert_Event();
            }
        });


    }

    private void insert_Event() {

        String eventID = EventID.getText().toString();
        String eventName = EventName.getText().toString();
        String timeStart = TimeStart.getText().toString();
        String timeEnd = TimeEnd.getText().toString();
        String address = Address.getText().toString();
        Integer requirement = Integer.parseInt(Requirement.getText().toString());
        Integer status = Integer.parseInt(Status.getText().toString());

        insert(eventID, eventName, timeStart, timeEnd, address, requirement, status);

    }

    private void insert(String eventID, String eventName, String timeStart, String timeEnd, String address, Integer requirement, Integer status) {

        eventID = EventID.getText().toString();
        eventName = EventName.getText().toString();
        timeStart = TimeStart.getText().toString();
        timeEnd = TimeEnd.getText().toString();
        address = Address.getText().toString();
        requirement = Integer.parseInt(Requirement.getText().toString());
        status = Integer.parseInt(Status.getText().toString());

        apiInterface_insertEvent = ApiClient.getClient().create(ApiInterface.class);
        Call<Event> eventCall = apiInterface_insertEvent.insert_Event(eventID, eventName, timeStart, timeEnd, address, requirement, status);
        eventCall.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {

                if (response.body().getResponse().equals("ok")) {
                    Toast.makeText(Insert_Event_Activity.this, "Lưu thành công!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Insert_Event_Activity.this, List_Event_Activity.class));
                }
                else {
                    Toast.makeText(Insert_Event_Activity.this,"Lưu thất bại", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                Toast.makeText(Insert_Event_Activity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Response fail", t.getLocalizedMessage(), t);
            }
        });
    }

    //anh xa
    private void initUI() {
        EventID = findViewById(R.id.insert_eventID);
        EventName = findViewById(R.id.insert_eventName);
        TimeStart = findViewById(R.id.insert_timeStart);
        TimeEnd = findViewById(R.id.insert_timeEnd);
        Address = findViewById(R.id.insert_addressEvent);
        Requirement = findViewById(R.id.insert_requirement);
        Status = findViewById(R.id.insert_status);

        btn_insertEvent = findViewById(R.id.btn_insertEvent);
    }
}