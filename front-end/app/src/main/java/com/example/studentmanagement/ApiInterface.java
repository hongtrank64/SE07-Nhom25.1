package com.example.studentmanagement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import src.Entity.Account;

public interface ApiInterface {

    @GET("/LoginRegister/login.php")
    Call<Login.ResponseContent> performUserLogin(@Query("username") String Username, @Query("password") String Password);

}
