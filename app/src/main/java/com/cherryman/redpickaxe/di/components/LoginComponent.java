package com.cherryman.redpickaxe.di.components;

import com.cherryman.redpickaxe.di.ActivityScope;
import com.cherryman.redpickaxe.di.modules.LoginModule;
import com.cherryman.redpickaxe.presentation.ui.login.LoginActivity;

import dagger.Component;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
@ActivityScope
@Component(
    dependencies = AppComponent.class,
    modules = LoginModule.class
)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
