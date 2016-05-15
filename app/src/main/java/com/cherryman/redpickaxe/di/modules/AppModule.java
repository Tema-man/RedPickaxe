package com.cherryman.redpickaxe.di.modules;

import com.cherryman.redpickaxe.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
@Module
public class AppModule {

    private final App mApp;

    public AppModule(App app) {
        this.mApp = app;
    }

    @Provides
    @Singleton
    public App provideApp() {
        return mApp;
    }
}
