package com.sangbook96.appdescription.api;

public class ApiUtils {
    public static final String BASE_URL = "http://admin.adtdisplay.vn/api/v1/";
    public static final String BASE_URL_UPLOAD = "http://admin.adtdisplay.vn/";
    public static APIPath APIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIPath.class);
    }
}
