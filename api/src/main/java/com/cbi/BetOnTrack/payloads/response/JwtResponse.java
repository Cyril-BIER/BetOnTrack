package com.cbi.BetOnTrack.payloads.response;

import java.util.List;

public record JwtResponse(String token, String type, Long id, String email, List<String> roles) {
}
