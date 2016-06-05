package com.cherryman.redpickaxe.data.repository.userstore;

import javax.inject.Singleton;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
@Singleton
public class UserStoreFactory {

    public UserStore create(){
        return new CloudUserStore();
    }
}
