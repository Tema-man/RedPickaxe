package com.cherryman.redpickaxe.data.repository.user;

import com.cherryman.redpickaxe.data.entity.UserEntity;
import com.cherryman.redpickaxe.data.net.RestApi;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
public class CloudUserStore implements UserStore {

    RestApi mRestApi;

    @Inject
    public CloudUserStore(RestApi restApi) {
        mRestApi = restApi;
    }


    @Override
    public Observable<UserEntity> getUserEntity(String apiKey) {
        return mRestApi.login(apiKey);
    }

    @Override
    public Observable<UserEntity> getUserEntity(String login, String password) {
        return mRestApi.login(login, password);
    }
}
