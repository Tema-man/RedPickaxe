package com.cherryman.redpickaxe.presentation.di.modules;

import android.content.Context;

import com.cherryman.redpickaxe.App;
import com.cherryman.redpickaxe.data.JobExecutor;
import com.cherryman.redpickaxe.data.net.ApiClient;
import com.cherryman.redpickaxe.data.net.RestApi;
import com.cherryman.redpickaxe.data.net.RestApiImpl;
import com.cherryman.redpickaxe.data.repository.UserRepositoryImpl;
import com.cherryman.redpickaxe.domain.executor.JobThread;
import com.cherryman.redpickaxe.domain.executor.PostThread;
import com.cherryman.redpickaxe.domain.repository.UserRepository;
import com.cherryman.redpickaxe.presentation.UIThread;

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

    @Provides @Singleton public App provideApp() {
        return mApp;
    }

    @Provides @Singleton Context provideAppContext() {
        return mApp.getApplicationContext();
    }

    @Provides @Singleton JobThread provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton PostThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton UserRepository provideUserRepository(UserRepositoryImpl userRepository) {
        return userRepository;
    }

    @Provides @Singleton ApiClient provideApiClient(Context appContext) {
        return new ApiClient(appContext);
    }

    @Provides @Singleton RestApi provideRestApi(ApiClient apiClient) {
        return new RestApiImpl(apiClient);
    }
}
