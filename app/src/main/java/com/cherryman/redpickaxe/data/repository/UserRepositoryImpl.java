package com.cherryman.redpickaxe.data.repository;

import com.cherryman.redpickaxe.data.entity.UserEntity;
import com.cherryman.redpickaxe.data.repository.user.UserStoreFactory;
import com.cherryman.redpickaxe.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Artemii Vishnevskii
 * @since 22.05.2016
 */
public class UserRepositoryImpl implements UserRepository {

    private UserStoreFactory mStoreFactory;

    @Inject
    public UserRepositoryImpl(UserStoreFactory factory) {
        mStoreFactory = factory;
    }

    @Override
    public Observable<UserEntity> authorize(String apiKey) {
        return mStoreFactory.create().getUserEntity(apiKey);
    }

    @Override
    public Observable<UserEntity> authorize(String login, String password) {
        return mStoreFactory.create().getUserEntity(login, password);
    }
}
