package com.cherryman.redpickaxe.presenters.impl;

import com.cherryman.redpickaxe.domain.exceptions.AppException;
import com.cherryman.redpickaxe.presenters.LoginPresenter;
import com.cherryman.redpickaxe.presenters.base.AbsPresenter;

/**
 * Created by Temaa on 15.05.2016.
 */
public class LoginPresenterImpl extends AbsPresenter<LoginPresenter.View> implements
    LoginPresenter {

    @Override
    public void onLoginClick(String login, String apiKey) {
        if (getView() != null) getView().showError(new AppException());
    }
}
