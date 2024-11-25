package com.cbi.BetOnTrack.payloads.request;

public record RegisterUserRequest(String email, String firstName, String lastName, String password) {
}
