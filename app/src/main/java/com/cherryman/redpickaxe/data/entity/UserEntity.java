package com.cherryman.redpickaxe.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity {

    @JsonProperty("id")
    public int id;

    @JsonProperty("login")
    public String login;

    @JsonProperty("firstname")
    public String firstname;

    @JsonProperty("lastname")
    public String lastname;

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
            "\n firstname = " + firstname +
            "\n lastname = " + lastname +
            "\n mail = " + mail +
            "\n createdOn = " + createdOn +
            "\n lastLoginOn = " + lastLoginOn +
            "\n apiKey = " + apiKey +
            "\n status = " + status +
            "\n---------------------------------";
    }

}
