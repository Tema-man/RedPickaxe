package com.cherryman.redpickaxe.data.net;

import com.cherryman.redpickaxe.data.entity.UserEntity;

import rx.Observable;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
public interface RestApi {

    Observable<UserEntity> login(String apiKey);

    Observable<UserEntity> login(String login, String password);
}
