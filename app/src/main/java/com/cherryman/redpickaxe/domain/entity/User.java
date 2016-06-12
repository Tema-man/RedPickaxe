package com.cherryman.redpickaxe.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Artemii Vishnevskii
 * @since 12.06.2016
 */
public class User {

    @JsonProperty("id")
    public int id;

    @JsonProperty("login")
    public String login;

    @JsonProperty("firstname")
    public String firstName;

    @JsonProperty("lastname")
    public String lastName;

    @JsonProperty("mail")
    public String mail;

    @JsonProperty("created_on")
    public Date createdOn;

    @JsonProperty("last_login_on")
    public Date lastLoginOn;

    @JsonProperty("api_key")
    public String apiKey;

    @JsonProperty("status")
    public int status;

    @Override
    public String toString() {
        return "" +
            "\n---------- User Entity ----------" +
            "\n id = " + id +
            "\n login = " + login +
            "\n firstname = " + firstName +
            "\n lastname = " + lastName +
            "\n mail = " + mail +
            "\n createdOn = " + createdOn +
            "\n lastLoginOn = " + lastLoginOn +
            "\n apiKey = " + apiKey +
            "\n status = " + status +
            "\n---------------------------------";
    }
}
