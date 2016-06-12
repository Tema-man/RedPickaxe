package com.cherryman.redpickaxe.presentation.di.components;

import com.cherryman.redpickaxe.presentation.di.PerActivity;
import com.cherryman.redpickaxe.presentation.di.modules.LoginModule;
import com.cherryman.redpickaxe.presentation.presenters.LoginPresenter;
import com.cherryman.redpickaxe.presentation.ui.login.LoginActivity;

import dagger.Component;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
@PerActivity
@Component(
    dependencies = AppComponent.class,
    modules = LoginModule.class
)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);

    LoginPresenter loginPresenter();
}
