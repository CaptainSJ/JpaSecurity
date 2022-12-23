package dev.captainsj.jpasecuritydemo.service;

import dev.captainsj.jpasecuritydemo.model.SecurityUser;
import dev.captainsj.jpasecuritydemo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository users;

    public JpaUserDetailsService(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return  users.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));



    }
}
