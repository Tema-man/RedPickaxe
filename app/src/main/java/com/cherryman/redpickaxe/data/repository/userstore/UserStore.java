package com.cherryman.redpickaxe.data.repository.userstore;

import com.cherryman.redpickaxe.data.entity.UserEntity;

import rx.Observable;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
public interface UserStore {
    Observable<UserEntity> getUserEntity(String apiKey);
}
