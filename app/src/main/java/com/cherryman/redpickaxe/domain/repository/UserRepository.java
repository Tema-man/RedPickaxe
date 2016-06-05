package com.cherryman.redpickaxe.domain.repository;

import com.cherryman.redpickaxe.data.entity.UserEntity;

import rx.Observable;

/**
 * @author Artemii Vishnevskii
 * @since 22.05.2016
 */
public interface UserRepository {
    Observable<UserEntity> authorize(String apiKey);

    Observable<UserEntity> authorize(String login, String password);
}
