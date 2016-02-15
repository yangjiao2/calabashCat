package com.calabashCat.android.sample.data.net;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class RetrofitService {
    private static final String API_BASE_URL = "https://api.yelp.com";
    private static final String consumerSey = "spD-AitIBDBq_iDe40tCtw";
    private static final String consumerSecret = "WupEEQXze7yad4nJFWOgmEewgWg";
    private static final String token = "SOvrf0G9XAkYKVGT4a3z7XtMN4KYN46v";
    private static final String tokenSecret = "nCns4vFHicoJJS9ZYZlSZc39jiI";

    private OkHttpClient httpClient;

    protected RetrofitService(String consumerKey, String consumerSecret, String token, String tokenSecret) {
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(consumerKey, consumerSecret);
        consumer.setTokenWithSecret(token, tokenSecret);
        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                //.addInterceptor(new ErrorHandlingInterceptor())
                .build();
    }

    private volatile static RetrofitService instance = null;

    public static RetrofitService getInstance() {
        if (instance == null) {
            synchronized (RetrofitService.class) {
                if (instance == null) {
                    instance = new RetrofitService(consumerSey, consumerSecret , token, tokenSecret);
                }
            }
        }
        return instance;
    }

    public RestApi createApi() {

        return new Retrofit.Builder()
                            .baseUrl(API_BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(RestApi.class);
    }
}
