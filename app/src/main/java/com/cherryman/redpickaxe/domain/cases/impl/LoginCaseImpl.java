package com.cherryman.redpickaxe.domain.cases.impl;

import android.text.TextUtils;

import com.cherryman.redpickaxe.data.entity.UserEntity;
import com.cherryman.redpickaxe.domain.repository.UserRepository;
import com.cherryman.redpickaxe.domain.cases.LoginCase;
import com.cherryman.redpickaxe.domain.cases.base.AbsCase;
import com.cherryman.redpickaxe.domain.executor.PostThread;
import com.cherryman.redpickaxe.domain.executor.JobThread;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Artemii Vishnevskii
 * @since 22.05.2016
 */
public class LoginCaseImpl extends AbsCase<UserEntity> implements LoginCase {

    private String mApiKey;
    private String mLogin;
    private String mPassword;

    UserRepository mUserRepository;

    @Inject
    public LoginCaseImpl(JobThread executor, PostThread postThread,
                         UserRepository userRepository) {
        super(executor, postThread);
        mUserRepository = userRepository;
    }

    @Override
    public void setApiKey(String apiKey) {
        mApiKey = apiKey;
    }

    @Override
    public void setCredentials(String login, String password) {
        mLogin = login;
        mPassword = password;
    }

    @Override
    public Observable<UserEntity> buildObservable() {
        if (!TextUtils.isEmpty(mApiKey)) {
            return mUserRepository.authorize(mApiKey);
        }
        return mUserRepository.authorize(mLogin, mPassword);
    }
}
