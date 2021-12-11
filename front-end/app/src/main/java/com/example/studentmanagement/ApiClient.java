package com.example.studentmanagement;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    // Viet retroifit sai roi, baseurl ko bao gom cai chi muc dang sau

    public static final String BASE_URL = "http://192.168.0.103"; //LoginRegister";
    public static Retrofit retrofit;

    public static Retrofit getApiClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
