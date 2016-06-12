package com.cherryman.redpickaxe.presentation.presenters.impl;

import android.util.Log;

import com.cherryman.redpickaxe.data.entity.UserEntity;
import com.cherryman.redpickaxe.domain.cases.LoginCase;
import com.cherryman.redpickaxe.exceptions.AppException;
import com.cherryman.redpickaxe.exceptions.Errors;
import com.cherryman.redpickaxe.presentation.di.PerActivity;
import com.cherryman.redpickaxe.presentation.presenters.LoginPresenter;
import com.cherryman.redpickaxe.presentation.presenters.base.AbsPresenter;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
@PerActivity
public class LoginPresenterImpl extends AbsPresenter<LoginPresenter.View> implements
    LoginPresenter {

    private static final String TAG = "LoginPresenterImpl";

    LoginCase mLoginCase;

    @Inject
    public LoginPresenterImpl(LoginCase loginCase) {
        mLoginCase = loginCase;
    }

    @Override
    public void onLoginClick(String login, String password) {
        mLoginCase.setCredentials(login, password);
//        mLoginCase.execute(this::onLogin, this::onLoginError);
        mLoginCase.execute(new Subscriber<UserEntity>() {
            @Override public void onCompleted() {

            }

            @Override public void onError(Throwable e) {
                onLoginError(Errors.network());
            }

            @Override public void onNext(UserEntity userEntity) {
                onLogin(userEntity);
            }
        });
    }

    private void onLogin(UserEntity user) {
        Log.d(TAG, "user Login" + user.user.toString());
    }

    private void onLoginError(AppException e) {
        if (getView() != null) getView().showError(e);
    }
}
