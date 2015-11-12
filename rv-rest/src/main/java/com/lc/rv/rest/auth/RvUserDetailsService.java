package com.lc.rv.rest.auth;

import com.lc.rv.entity.User;
import com.lc.rv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Alexey.Koyro
 */
public class RvUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }


        return new org.springframework.security.core.userdetails.User("someUser", "encodedPassword",
                Arrays.asList(new SimpleGrantedAuthority("ADMIN")));
    }
}
