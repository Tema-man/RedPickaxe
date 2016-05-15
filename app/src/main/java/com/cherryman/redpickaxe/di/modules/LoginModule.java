package com.cherryman.redpickaxe.di.modules;

import com.cherryman.redpickaxe.presenters.LoginPresenter;
import com.cherryman.redpickaxe.presenters.impl.LoginPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
@Module
public class LoginModule {

    @Provides
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenterImpl();
    }
}
