package com.cherryman.redpickaxe.data.repository.user;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
@Singleton
public class UserStoreFactory {

    private CloudUserStore mCloudUserStore;

    @Inject
    public UserStoreFactory(CloudUserStore cloudUserStore) {
        mCloudUserStore = cloudUserStore;
    }

    public UserStore create() {
        return mCloudUserStore;
    }
}
