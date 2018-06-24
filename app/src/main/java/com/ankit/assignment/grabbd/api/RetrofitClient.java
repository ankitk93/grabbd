package com.ankit.assignment.grabbd.api;

import com.ankit.assignment.grabbd.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit mRetrofit = null;

    public static Retrofit getClient(){
        if (mRetrofit == null){
            Gson mGson = new GsonBuilder().setLenient().create();

            mRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(mGson))
                    .client(okHttpClient())
                    .build();

        }
        return mRetrofit;
    }

    public static OkHttpClient okHttpClient(){
        return new OkHttpClient.Builder()
                .readTimeout(180 , TimeUnit.SECONDS)
                .connectTimeout(180 , TimeUnit.SECONDS)
                .build();
    }
}
