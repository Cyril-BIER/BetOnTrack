package com.cbi.BetOnTrack.service;

import com.cbi.BetOnTrack.model.Profile.User;
import com.cbi.BetOnTrack.payloads.request.LoginRequest;
import com.cbi.BetOnTrack.payloads.request.RegisterUserRequest;
import com.cbi.BetOnTrack.payloads.response.JwtResponse;
import com.cbi.BetOnTrack.repository.UserRepository;
import com.cbi.BetOnTrack.security.jwt.JwtUtils;
import com.cbi.BetOnTrack.security.service.UserDetailsImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Transactional
    public boolean registerUser(RegisterUserRequest request){
        userRepository.save(new User(request.firstName(),
                request.lastName(),
                request.email(),
                encoder.encode(request.password())));
        return true;
    }

    public JwtResponse authenticateProfile(LoginRequest request){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        Authentication authentication = authenticationManager.authenticate(
                usernamePasswordAuthenticationToken
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        if(roles.contains("ROLE_USER")){
            User user = userRepository.findById(userDetails.getId()).get();
        }
        return new JwtResponse(jwt,"Bearer" ,userDetails.getId(), userDetails.getEmail(),roles);
    }


}
