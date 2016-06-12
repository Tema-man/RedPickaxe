package com.cherryman.redpickaxe.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.cherryman.redpickaxe.data.mapping.JsonParser;
import com.cherryman.redpickaxe.exceptions.AppException;
import com.cherryman.redpickaxe.exceptions.Errors;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
public class ApiClient {

    private Context mAppContext;
    private OkHttpClient mHttpClient;

    private String mHost;

    @Inject
    public ApiClient(Context context) {
        mAppContext = context;
        createHttpClient();
        mHost = "http://redmine.meshsecret.com";
    }

    private void createHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mHttpClient = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build();
    }

    private boolean isInternetAvailable() {
        ConnectivityManager connectivityManager =
            (ConnectivityManager) mAppContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnectedOrConnecting());
    }

    public HttpUrl.Builder host() {
        return HttpUrl.parse(mHost).newBuilder();
    }

    public <R> R makeRequest(Class<R> responseClass, Request request) throws AppException {
        if (!isInternetAvailable()) throw Errors.noInternet();
        try {
            Response response = mHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseString = response.body().string();
                if (TextUtils.isEmpty(responseString)) return null;
                return JsonParser.entity(responseString, responseClass);
            } else {
                throw Errors.network();
            }
        } catch (IOException ioe) {
            throw Errors.noInternet();
        }
    }
}
