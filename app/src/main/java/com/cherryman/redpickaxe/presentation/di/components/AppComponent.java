package com.cherryman.redpickaxe.presentation.di.components;

import android.content.Context;

import com.cherryman.redpickaxe.App;
import com.cherryman.redpickaxe.data.repository.user.UserStoreFactory;
import com.cherryman.redpickaxe.domain.executor.JobThread;
import com.cherryman.redpickaxe.domain.executor.PostThread;
import com.cherryman.redpickaxe.domain.repository.UserRepository;
import com.cherryman.redpickaxe.presentation.di.modules.AppModule;

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

    Context context();

    JobThread threadExecutor();

    PostThread postExecutionThread();

    UserRepository userRepository();

    UserStoreFactory userStoreFactory();
}
