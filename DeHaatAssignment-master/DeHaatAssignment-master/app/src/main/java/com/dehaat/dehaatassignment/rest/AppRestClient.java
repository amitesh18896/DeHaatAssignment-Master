package com.dehaat.dehaatassignment.rest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRestClient {

    public static final String BASE_URL = "https://7847f517-3b22-4dff-a6b9-cf9cd46c6762.mock.pstmn.io";
    int CACHE_SIZE = 10 * 1024 * 1024; // 10 MB
    public static final long CONNECT_TIMEOUT = 30000;
    public static final long READ_TIMEOUT = 30000;
    public static final long WRITE_TIMEOUT = 30000;

    public static AppRestClient getInstance() {
        return mInstance;
    }


    private static Context context;
    private static AppRestClient mInstance;
    private AppRestClientService appRestClientService;

    private AppRestClient() {
        setRestClient();
    }

    public static AppRestClient init(Context context) {
        AppRestClient.context = context;
        if (mInstance == null) {
            synchronized (AppRestClient.class) {
                if (mInstance == null)
                    mInstance = new AppRestClient();
            }
        }
        return mInstance;
    }

    public static void setAppRestClientNull() {
        mInstance = null;
    }

    private void setRestClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build();

        appRestClientService = retrofit.create(AppRestClientService.class);
    }

    private OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                .cache(new Cache(context.getCacheDir(), CACHE_SIZE))
                .addInterceptor(getCacheInterceptor())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    private Interceptor getCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (hasNetwork()) { // If there is Internet, get the cache that was stored 5 seconds ago otherwise discard.
                    request = request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build();
                } else { //If there is no Internet, get the cache that was stored 7 days ago otherwise discard.
                    request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                }
                return chain.proceed(request);
            }
        };
    }

    private boolean hasNetwork() {
        boolean isConnected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (null != activeNetworkInfo && activeNetworkInfo.isConnected())
            isConnected = true;

        return isConnected;
    }

}
