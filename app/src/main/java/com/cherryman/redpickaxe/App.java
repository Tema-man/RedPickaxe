package com.cherryman.redpickaxe;

import android.app.Application;
import android.content.Context;

import com.cherryman.redpickaxe.di.components.AppComponent;
import com.cherryman.redpickaxe.di.components.DaggerAppComponent;
import com.cherryman.redpickaxe.di.modules.AppModule;
import com.crashlytics.android.core.CrashlyticsCore;

import io.fabric.sdk.android.Fabric;

/**
 * @author Artemii Vishnevskii
 * @author Temaa.mann@gmail.com
 * @since 22.04.2016.
 */
public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildGraphAndInject();

        Fabric.with(getApplicationContext(),
            new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build());

    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    private void buildGraphAndInject() {
        mAppComponent = DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .build();
        mAppComponent.inject(this);
    }
}
