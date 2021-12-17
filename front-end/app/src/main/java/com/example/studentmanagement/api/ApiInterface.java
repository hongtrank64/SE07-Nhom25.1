package com.example.studentmanagement.api;

import retrofit2.Call;
import retrofit2.http.GET;
import Entity.Account;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/LoginRegister/login.php")
    Call<Account> performUserLogin(@Query("username") String Username, @Query("password") String Password);

}
