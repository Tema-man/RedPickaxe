package com.cherryman.redpickaxe.di.components;

import com.cherryman.redpickaxe.App;
import com.cherryman.redpickaxe.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
@Singleton
@Component(
    modules = AppModule.class
)
public interface AppComponent {
    void inject(App app);
}
