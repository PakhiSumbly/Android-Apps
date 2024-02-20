package com.pakhi.newcashingapp.api;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class RetrofitClient {
    private static final Retrofit instance = new Retrofit.Builder().baseUrl(APIConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();


    private RetrofitClient(){

    }

   public static Retrofit getInstance(){
       return instance;
   }
}
