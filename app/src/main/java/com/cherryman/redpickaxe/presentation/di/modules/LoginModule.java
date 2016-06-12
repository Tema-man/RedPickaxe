package com.cherryman.redpickaxe.presentation.di.modules;

import com.cherryman.redpickaxe.data.net.RestApi;
import com.cherryman.redpickaxe.data.repository.user.CloudUserStore;
import com.cherryman.redpickaxe.data.repository.user.UserStoreFactory;
import com.cherryman.redpickaxe.domain.cases.LoginCase;
import com.cherryman.redpickaxe.domain.cases.impl.LoginCaseImpl;
import com.cherryman.redpickaxe.domain.executor.JobThread;
import com.cherryman.redpickaxe.domain.executor.PostThread;
import com.cherryman.redpickaxe.domain.repository.UserRepository;
import com.cherryman.redpickaxe.presentation.presenters.LoginPresenter;
import com.cherryman.redpickaxe.presentation.presenters.impl.LoginPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
@Module
public class LoginModule {

    @Provides LoginPresenter provideLoginPresenter(LoginCase loginCase) {
        return new LoginPresenterImpl(loginCase);
    }

    @Provides LoginCase provideLoginCase(JobThread executor, PostThread postThread,
                                         UserRepository userRepository) {
        return new LoginCaseImpl(executor, postThread, userRepository);
    }

    @Provides @Singleton CloudUserStore provideCloudUserStore(RestApi restApi) {
        return new CloudUserStore(restApi);
    }

    @Provides @Singleton UserStoreFactory provideUserFactory(CloudUserStore cloudUserStore) {
        return new UserStoreFactory(cloudUserStore);
    }
}
