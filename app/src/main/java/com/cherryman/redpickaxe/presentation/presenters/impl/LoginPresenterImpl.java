package com.cherryman.redpickaxe.presentation.presenters.impl;

import android.util.Log;

import com.cherryman.redpickaxe.domain.cases.LoginCase;
import com.cherryman.redpickaxe.exceptions.AppException;
import com.cherryman.redpickaxe.presentation.presenters.LoginPresenter;
import com.cherryman.redpickaxe.presentation.presenters.base.AbsPresenter;

import javax.inject.Inject;

/**
 * Created by Temaa on 15.05.2016.
 */
public class LoginPresenterImpl extends AbsPresenter<LoginPresenter.View> implements
    LoginPresenter {

    private static final String TAG = "LoginPresenterImpl";

    @Inject LoginCase mLoginCase;

    @Override
    public void onLoginClick(String login, String apiKey) {
        mLoginCase.execute(userEntity -> {
            Log.d(TAG, "user Login" + userEntity.toString());
        });
        if (getView() != null) getView().showError(new AppException());
    }
}
