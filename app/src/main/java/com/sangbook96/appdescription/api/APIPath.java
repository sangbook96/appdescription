package com.sangbook96.appdescription.api;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface APIPath {

    @GET("home?deviceId=33&orientation=0")
    Call<ResponseBody> dataHome(@Header("Authorization") String token);


}
