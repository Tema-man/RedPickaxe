package com.cherryman.redpickaxe.presenters;

import com.cherryman.redpickaxe.domain.exceptions.AppException;
import com.cherryman.redpickaxe.presenters.base.BaseView;
import com.cherryman.redpickaxe.presenters.base.Presenter;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
public interface LoginPresenter extends Presenter<LoginPresenter.View> {

    void onLoginClick(String login, String apiKey);

    interface View extends BaseView {
        void showError(AppException e);
    }
}
