package com.cherryman.redpickaxe.data.entity;

import com.cherryman.redpickaxe.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity {

    @JsonProperty("user")
    public User user;
}
