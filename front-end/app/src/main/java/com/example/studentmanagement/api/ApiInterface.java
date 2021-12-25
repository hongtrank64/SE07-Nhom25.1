package com.example.studentmanagement.api;

import java.util.Date;

import Entity.Student;
import retrofit2.Call;
import retrofit2.http.GET;
import Entity.Account;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/LoginRegister/login_all.php")
    Call<Account> performUserLogin(@Query("username") String Username, @Query("password") String Password );

    @GET("/LoginRegister/signup.php")
    Call<Account> performUserSignup(@Query("studentID") String StudentID, @Query("username") String Username, @Query("password") String Password );

    @GET("/LoginRegister/profile.php")
    Call<Student> profile_Student(@Query("studentID") String StudentID );

    @GET("/LoginRegister/insert_profile.php")
    Call<Student> insert_Student(@Query("studentID") String StudentID, @Query("fullname") String Fullname, @Query("gender") String Gender,
                                 @Query("birthday") Date Birth, @Query("address") String Address, @Query("classroom") String Classroom,
                                 @Query("email") String Email, @Query("phone") String Phone, @Query("GPA") Float GPA);

    @GET("/LoginRegister/update.php")
    Call<Student> update_Student(@Query("studentID") String StudentID, @Query("address") String Address, @Query("email") String Email, @Query("phone") String Phone);




}
