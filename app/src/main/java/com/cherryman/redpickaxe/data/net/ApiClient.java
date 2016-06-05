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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
public class ApiClient {

    @Inject OkHttpClient mHttpClient;
    @Inject Context mAppContext;

    public ApiClient() {
        createHttpClient();
    }

    private void createHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mHttpClient = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build();
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

    private boolean isInternetAvailable() {
        ConnectivityManager connectivityManager =
            (ConnectivityManager) mAppContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnectedOrConnecting());
    }
}
