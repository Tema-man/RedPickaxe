package com.cherryman.redpickaxe.domain.cases.impl;

import android.text.TextUtils;

import com.cherryman.redpickaxe.data.entity.UserEntity;
import com.cherryman.redpickaxe.domain.repository.UserRepository;
import com.cherryman.redpickaxe.domain.cases.LoginCase;
import com.cherryman.redpickaxe.domain.cases.base.AbsCase;
import com.cherryman.redpickaxe.domain.executor.PostThread;
import com.cherryman.redpickaxe.domain.executor.ThreadExecutor;

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

    @Inject UserRepository mUserRepository;

    @Inject
    public LoginCaseImpl(ThreadExecutor executor, PostThread postThread) {
        super(executor, postThread);
    }

    @Override
    public void setApiKey(String apiKey) {
        mApiKey = apiKey;
    }

    @Override
    public void setCredentioals(String login, String password) {
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
