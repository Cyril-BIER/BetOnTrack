package com.cbi.BetOnTrack.model.Profile;

import jakarta.persistence.Entity;

@Entity
public class User extends Profile{
    public User() {}

    public User(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }
}
