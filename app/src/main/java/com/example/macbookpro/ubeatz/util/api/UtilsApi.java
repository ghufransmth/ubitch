package com.example.macbookpro.ubeatz.util.api;

/**
 * Created by Ghufran on 11/26/2017.
 */

public class UtilsApi {
    // 10.0.2.2 ini adalah localhost.
    public static final String BASE_URL_API = "http://ubeatz.rapiertechnology.co.id/";
//    public static final String BASE_URL_API = "http://192.168.100.8/mantap-stage/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
