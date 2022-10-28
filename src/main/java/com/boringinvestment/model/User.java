package com.boringinvestment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "user")
public class User extends PanacheMongoEntity {
    public String login;
    public String email;
    @JsonIgnore
    public String password;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
