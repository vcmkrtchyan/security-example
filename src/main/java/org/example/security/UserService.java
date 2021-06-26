package org.example.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserService implements UserDetailsService {

    private final List<UserDetails> users = Arrays.asList(
            new User(
                    "valodik",
                    "valodik",
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User(
                    "admin_valodik",
                    "admin_valodik",
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
            )
    );

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        for (UserDetails user : users) {
            if (user.getUsername().equals(s)) {
                return user;
            }
        }

        return null;
    }
}
