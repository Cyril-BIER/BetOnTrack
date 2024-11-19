package com.cbi.BetOnTrack.security.service;

import com.cbi.BetOnTrack.model.Profile.Profile;
import com.cbi.BetOnTrack.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    ProfileRepository profileRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("Profile Not Found with email : "+email));

        return UserDetailsImpl.build(profile);
    }
}
