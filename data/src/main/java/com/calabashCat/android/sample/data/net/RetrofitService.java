package com.calabashCat.android.sample.data.net;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class RetrofitService {
    private static final String API = "https://api.yelp.com";

    protected RetrofitService() {
    }

    private volatile static RetrofitService instance = null;

    public static RetrofitService getInstance() {
        if (instance == null) {
            synchronized (RetrofitService.class) {
                if (instance == null) {
                    instance = new RetrofitService();
                }
            }
        }
        return instance;
    }

    private volatile static RestApi gitHubApi = null;

    public static RestApi createApi() {
        if (gitHubApi == null) {
            synchronized (RetrofitService.class) {
                if (gitHubApi == null) {
                    gitHubApi = new Retrofit.Builder()
                            .baseUrl(API)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build().create(RestApi.class);
                }
            }
        }
        return gitHubApi;
    }
}
