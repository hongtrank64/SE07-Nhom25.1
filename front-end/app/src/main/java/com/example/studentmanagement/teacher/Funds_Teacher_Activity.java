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

import Entity.Money;
import Entity.Student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Funds_Teacher_Activity extends AppCompatActivity {
    private TableLayout tblayout_listFunds;
    private ApiInterface apiInterface_ListFunds;
    private List<Money> list_Funds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funds_teacher);

        tblayout_listFunds = findViewById(R.id.table_list_funds);

        apiInterface_ListFunds = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Money>> list_money = apiInterface_ListFunds.list_Money();
        list_money.enqueue(new Callback<List<Money>>() {
            @Override
            public void onResponse(Call<List<Money>> call, Response<List<Money>> response) {

                list_Funds = response.body();
                if (response.isSuccessful()) {
                    double total = 0.0; //so tien con lai
                    for (int i = 0; i < list_Funds.size(); i++) {
                        TableRow tableRow = new TableRow(Funds_Teacher_Activity.this);
                        tableRow.setPadding(10, 0, 10, 0);

                        TextView ID_funds = new TextView(Funds_Teacher_Activity.this);
                        ID_funds.setTextSize(20);
                        ID_funds.setGravity(Gravity.CENTER);
                        ID_funds.setBackgroundResource(R.drawable.border);

                        TextView money_name = new TextView(Funds_Teacher_Activity.this);
                        money_name.setTextSize(20);
                        money_name.setGravity(Gravity.CENTER);
                        money_name.setBackgroundResource(R.drawable.border);

                        TextView money_fly = new TextView(Funds_Teacher_Activity.this);
                        money_fly.setTextSize(20);
                        money_fly.setGravity(Gravity.CENTER);
                        money_fly.setBackgroundResource(R.drawable.border);

                        TextView funds_type = new TextView(Funds_Teacher_Activity.this);
                        funds_type.setTextSize(20);
                        funds_type.setGravity(Gravity.CENTER);
                        funds_type.setBackgroundResource(R.drawable.border);

                        ID_funds.setText(String.valueOf(list_Funds.get(i).getId()));
                        money_name.setText(list_Funds.get(i).getNameMoney());
                        money_fly.setText(String.valueOf(list_Funds.get(i).getMoney()));

                        int root = list_Funds.get(i).getRoot();
                        if (root == 0) {
                            funds_type.setText("Khoản thu");
                            total += list_Funds.get(i).getMoney();
                        }
                        if (root == 1) {
                            funds_type.setText("Khoản chi");
                            total -= list_Funds.get(i).getMoney();
                        }


                        tableRow.addView(ID_funds);
                        tableRow.addView(money_name);
                        tableRow.addView(money_fly);
                        tableRow.addView(funds_type);

                        tblayout_listFunds.addView(tableRow);
                    }

                    //show so du
                    TableRow tbrowTotal = new TableRow(Funds_Teacher_Activity.this);
                    tbrowTotal.setPadding(20, 100, 0, 0);
                    TextView totalFunds = new TextView(Funds_Teacher_Activity.this);
                    totalFunds.setTextSize(20);
                    totalFunds.setText("Còn lại: " + String.valueOf(total));

                    tbrowTotal.addView(totalFunds);
                    tblayout_listFunds.addView(tbrowTotal);

                }


            }

            @Override
            public void onFailure(Call<List<Money>> call, Throwable t) {
                Toast.makeText(Funds_Teacher_Activity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Response fail", t.getLocalizedMessage(), t);

            }
        });
    }
}