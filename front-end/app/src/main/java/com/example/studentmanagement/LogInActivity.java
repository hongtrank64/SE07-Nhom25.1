package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagement.api.ApiClient;
import com.example.studentmanagement.api.ApiInterface;

import Entity.Account;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {

    private EditText Username, Password;
    private Button btnLogIn, btnExit;
    private ApiInterface apiInterface;
    Vibrator v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        btnLogIn = findViewById(R.id.btndangnhap);
        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LogIn();

            }
        });

        btnExit = findViewById(R.id.btnthoat);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogExit();
            }
        });

    }

    private void LogIn() {

        String username = Username.getText().toString();
        String password = Password.getText().toString();
        if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
            Username.setError("Vui lòng nhập tên đăng nhập");
            Password.setError("Vui lòng nhập mật khẩu");
        }

        if (TextUtils.isEmpty(username)) {
            Username.setError("Vui lòng nhập tên đăng nhập");
            Username.requestFocus();
            // Vibrate for 100 milliseconds
            v.vibrate(100);
            btnLogIn.setEnabled(true);
            return;
        }
        //checking if password is empty
        if (TextUtils.isEmpty(password)) {
            Password.setError("Vui lòng nhập mật khẩu");
            Password.requestFocus();

            //Vibrate for 100 milliseconds
            v.vibrate(100);
            btnLogIn.setEnabled(true);
            return;
        }

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Account> accountCall = apiInterface.performUserLogin(username, password);
        accountCall.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {

                if (response.body().getResponse().equals("ok")) {
                    int mRoot = response.body().getRoot();

                    if (mRoot == 2) {
                        //get username
                        String user = response.body().getUsername(); // null?

                        //lưu trữ người dùng trong các tùy chọn được chia sẻ
                        SharedPref.getInstance(LogInActivity.this).storeUserName(user);
                        Toast.makeText(LogInActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LogInActivity.this, AfterLogInActivity.class));
                    }

                    else if (mRoot == 1){
                        Toast.makeText(LogInActivity.this, "Đăng nhập ... công", Toast.LENGTH_LONG).show();
                    }
                }

                else {
                    Toast.makeText(LogInActivity.this, "Đăng nhập thất bại",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Toast.makeText(LogInActivity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Response fail", t.getLocalizedMessage(), t);
            }



        });

        Username.setText("");
        Password.setText("");


    }

    private void DialogExit() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogexit);

        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialog.findViewById(R.id.btndongy);
        Button btnNo = dialog.findViewById(R.id.btnhuybo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, LogInActivity.class);
                startActivity(intent);

                //Thoat
                Intent intent1 = new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }
}