package com.cherryman.redpickaxe.data.net;

import com.cherryman.redpickaxe.data.entity.UserEntity;
import com.cherryman.redpickaxe.exceptions.AppException;

import javax.inject.Inject;

import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Request;
import rx.Observable;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
public class RestApiImpl implements RestApi {

    @Inject ApiClient mApiClient;

    @Override
    public Observable<UserEntity> login(String apiKey) {
        return Observable.create(subscriber -> {
            HttpUrl url = HttpUrl.parse(Urls.HOST).newBuilder()
                .addPathSegment(Urls.MY_USER)
                .build();

            Request request = new Request.Builder().url(url)
                .header("X-Redmine-API-Key", apiKey).build();

            try {
                UserEntity user = mApiClient.makeRequest(UserEntity.class, request);
                subscriber.onNext(user);
                subscriber.onCompleted();
            } catch (AppException e) {
                subscriber.onError(e);
            }
        });
    }

    @Override
    public Observable<UserEntity> login(String login, String password) {
        return Observable.create(subscriber -> {
            HttpUrl url = HttpUrl.parse(Urls.HOST).newBuilder()
                .addPathSegment(Urls.MY_USER)
                .build();

            String credential = Credentials.basic("tema_man", "abc31415926");

            Request request = new Request.Builder().url(url)
                .header("Authorization", credential).build();

            try {
                UserEntity user = mApiClient.makeRequest(UserEntity.class, request);
                subscriber.onNext(user);
                subscriber.onCompleted();
            } catch (AppException e) {
                subscriber.onError(e);
            }
        });
    }
}
