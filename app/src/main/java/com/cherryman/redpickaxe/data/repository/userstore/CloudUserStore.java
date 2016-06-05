package com.cherryman.redpickaxe.data.repository.userstore;

import com.cherryman.redpickaxe.data.entity.UserEntity;
import com.cherryman.redpickaxe.data.net.RestApi;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
public class CloudUserStore implements UserStore {

    @Inject RestApi mRestApi;

    @Override
    public Observable<UserEntity> getUserEntity(String apiKey) {
        return mRestApi.login(apiKey);
    }
}
