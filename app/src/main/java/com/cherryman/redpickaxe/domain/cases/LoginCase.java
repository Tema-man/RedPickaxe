package com.cherryman.redpickaxe.domain.cases;

import com.cherryman.redpickaxe.data.entity.UserEntity;
import com.cherryman.redpickaxe.domain.cases.base.Case;

/**
 * @author Artemii Vishnevskii
 * @since 22.05.2016
 */
public interface LoginCase extends Case<UserEntity> {

    void setApiKey(String apiKey);

    void setCredentials(String login, String password);
}
