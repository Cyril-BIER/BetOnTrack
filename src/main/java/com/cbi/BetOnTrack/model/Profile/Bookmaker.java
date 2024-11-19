package com.cbi.BetOnTrack.model.Profile;

import jakarta.persistence.Entity;

@Entity
public class Bookmaker extends Profile{
    public Bookmaker() {super();}

    public Bookmaker(String firstName, String lastName, String email, String password){
        super(firstName, lastName, email, password);
    }
}
