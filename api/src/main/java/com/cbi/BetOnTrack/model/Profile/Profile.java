package com.cbi.BetOnTrack.model.Profile;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public abstract class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String firstName;

    protected String lastName;

    @NotNull
    @Column(unique = true)
    protected String email;

    @NotNull
    protected String password;

    public Profile(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Profile() {}

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
