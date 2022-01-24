package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class Signup_Activity extends AppCompatActivity {

    private EditText StudentID, Username, Password, Re_Password;
    private Button btnSignUp;
    private ApiInterface apiInterface_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        StudentID = findViewById(R.id.studentID);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        Re_Password = findViewById(R.id.re_password);

        btnSignUp = findViewById(R.id.btndangki);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });
    }

    private void SignUp() {

        String studentID = StudentID.getText().toString();
        String username = Username.getText().toString();
        String password = Password.getText().toString();
        String re_password = Re_Password.getText().toString();

        //kiểm tra xem ID có trống không
        if (TextUtils.isEmpty(studentID)) {
            StudentID.setError("Vui lòng nhập ID");
            StudentID.requestFocus();
            return;
        }

        //kiểm tra xem tên người dùng có trống không
        if (TextUtils.isEmpty(username)) {
            Username.setError("Vui lòng nhập tên đăng nhập");
            Username.requestFocus();
            return;
        }

        // kiểm tra xem mật khẩu có trống không
        if (TextUtils.isEmpty(password)) {
            Password.setError("Vui lòng nhập mật khẩu");
            Password.requestFocus();
        }

        // kiểm tra xem nhập lại mật khẩu có trống không
        if (TextUtils.isEmpty(password)) {
            Re_Password.setError("Vui lòng nhập lại mật khẩu");
            Re_Password.requestFocus();
        }

        //kiểm tra xem mật khẩu có khớp không
        if (!password.equals(re_password)) {
            Re_Password.setError("Mật khẩu không khớp");
            Re_Password.requestFocus();

            return;
        }

        //Sau khi xác thực, đăng ký người dùng
        registerUser(studentID, username, password);


    }

    private void registerUser(String user_studentID, String user_name, String user_password) {

        user_studentID = StudentID.getText().toString();
        user_name = Username.getText().toString();
        user_password = Password.getText().toString();

        //call retrofit
        //making api call
        apiInterface_signup = ApiClient.getClient().create(ApiInterface.class);
        Call<Account> accountCall_reg = apiInterface_signup.performUserSignup(user_studentID, user_name, user_password);
        accountCall_reg.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {

                if (response.body().getResponse().equals("ok")) {
                    Toast.makeText(Signup_Activity.this, "Đăng kí thành công", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Signup_Activity.this, Teacher_Activity.class));

                }
                else {
                    Toast.makeText(Signup_Activity.this,"Đăng kí thất bại", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Toast.makeText(Signup_Activity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Response fail", t.getLocalizedMessage(), t);

            }
        });




    }

}