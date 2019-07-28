package com.sangbook96.appdescription.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.sangbook96.appdescription.util.Config.TIME_OUT_SERVER;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    public static Retrofit getClient(String base_url) {
        OkHttpClient builder = new OkHttpClient.Builder()
                .readTimeout(TIME_OUT_SERVER, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT_SERVER, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT_SERVER * 2, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .client(builder)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }


}
