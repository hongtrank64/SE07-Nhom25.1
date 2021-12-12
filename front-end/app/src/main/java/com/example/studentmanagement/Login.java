package com.example.studentmanagement;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import retrofit2.Call;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import retrofit2.Callback;
import retrofit2.Response;
import src.Entity.Account;

public class Login extends Fragment {

    private EditText Username, Password;
    private Button LogIn_btn, Exit_btn;

    OnLoginFormActivityListener loginFormActivityListener;

    public interface OnLoginFormActivityListener {
        public void performLogin(String studentID);
    }

    public Login() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        Username = view.findViewById(R.id.username);
        Password = view.findViewById(R.id.password);

        LogIn_btn = view.findViewById(R.id.btndangnhap);
        LogIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogIn();
            }
        });

        Exit_btn = view.findViewById(R.id.btnthoat);
        Exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogExit();
            }
        });

        return view;

    }

    private void DialogExit() {
//        Dialog dialog = new Dialog();
//        dialog.setContentView(R.layout.dialogexit);
//
//        dialog.setCanceledOnTouchOutside(false);
//
//        Button btnYes = dialog.findViewById(R.id.btndongy);
//        Button btnNo = dialog.findViewById(R.id.btnhuybo);
//
//        btnYes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Login.this, Login.class);
//            }
//        });
    }

    @Override
    public void onAttach(@NonNull Context context) { // trong kia lại không ghi, hàm này thực hiện khi cái fragment này được đưa vào act
        super.onAttach(context);
        Activity activity = (Activity) context;
        loginFormActivityListener = (OnLoginFormActivityListener) activity;
    }

    public class ResponseContent {
        @SerializedName("response")
        private String response;
        @SerializedName("studentID")
        private String studentID;

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }

        public String getStudentID() {
            return studentID;
        }

        public void setStudentID(String studentID) {
            this.studentID = studentID;
        }
    }

    private void performLogIn() {

        String username = Username.getText().toString();
        String password = Password.getText().toString();

        Call<ResponseContent> call = MainActivity.apiInterface.performUserLogin(username, password);
        call.enqueue(new Callback<ResponseContent>() {
            @Override
            public void onResponse(Call<ResponseContent> call, Response<ResponseContent> response) {
                if (response.body() != null && response.body().getResponse().equals("ok")) {
                    MainActivity.prefConfig.writeLoginStatus(true);
                    loginFormActivityListener.performLogin(response.body().getStudentID());
                }
                else if (username.isEmpty() || password.isEmpty()) {
                    if (username.isEmpty()) {
                        Username.setError("Vui lòng nhập tên đăng nhập");
                    }
                    else {
                        Username.setText(username);
                        Password.setError("Vui lòng nhập mật khẩu");
                    }
                }

                else {
                    MainActivity.prefConfig.displayToast("Tên đăng nhập hoặc mật khẩu không đúng...Vui lòng thử lại...");
                }
            }

            @Override
            public void onFailure(Call<ResponseContent> call, Throwable t) {

            }
        });


        Username.setText("");
        Password.setText("");
    }
}