package com.cbi.BetOnTrack.model.Profile;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Profile{
    public Admin() {super();}

    public Admin(String firstName, String lastName, String email, String password){
        super(firstName, lastName, email, password);
    }
}
