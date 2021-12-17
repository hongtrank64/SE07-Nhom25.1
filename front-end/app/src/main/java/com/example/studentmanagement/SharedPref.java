package com.example.studentmanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPref {

    //Storage File
    public static final String SHARED_PREF_NAME = "LoginRegister";

    //Username
    public static final String USER_NAME = "username";

    public static SharedPref sharedPref;

    private Context Ctx;


    public SharedPref(Context context) {
        this.Ctx = context;
    }

    public static synchronized SharedPref getInstance(Context context) {

        if (sharedPref == null) {
            sharedPref = new SharedPref(context);
        }
        return sharedPref;
    }

    //phương thức lưu trữ dữ liệu người dùng
    public void storeUserName(String names) {
        SharedPreferences sharedPreferences = Ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, names);
        editor.commit();
    }

    //kiểm tra xem người dùng đã đăng nhập chưa
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = Ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_NAME, null) != null;
    }


    //tìm người dùng đã đăng nhập
    public String LoggedInUser() {
        SharedPreferences sharedPreferences = Ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_NAME, null);

    }

    //Đăng xuất
    public void LogOut() {
        SharedPreferences sharedPreferences = Ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Ctx.startActivity(new Intent(Ctx, LogInActivity.class));
    }
}
