package com.cherryman.redpickaxe.di.modules;

import com.cherryman.redpickaxe.data.repository.UserRepositoryImpl;
import com.cherryman.redpickaxe.data.repository.userstore.UserStoreFactory;
import com.cherryman.redpickaxe.domain.cases.LoginCase;
import com.cherryman.redpickaxe.domain.cases.impl.LoginCaseImpl;
import com.cherryman.redpickaxe.domain.executor.PostThread;
import com.cherryman.redpickaxe.domain.executor.ThreadExecutor;
import com.cherryman.redpickaxe.domain.repository.UserRepository;
import com.cherryman.redpickaxe.presentation.presenters.LoginPresenter;
import com.cherryman.redpickaxe.presentation.presenters.impl.LoginPresenterImpl;

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

    @Provides
    UserStoreFactory provideUserStoreFactory() {
        return new UserStoreFactory();
    }

    @Provides
    UserRepository provideUserRepository(UserStoreFactory storeFactory) {
        return new UserRepositoryImpl(storeFactory);
    }

    @Provides
    public LoginCase provideLoginCase(ThreadExecutor executor, PostThread postThread) {
        return new LoginCaseImpl(executor, postThread);
    }
}
