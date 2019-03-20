package com.yevhenii.to_do_list.service;

import com.yevhenii.to_do_list.exception.TokenCreationException;
import com.yevhenii.to_do_list.exception.UserNotFoundException;
import com.yevhenii.to_do_list.model.Role;
import com.yevhenii.to_do_list.model.User;
import com.yevhenii.to_do_list.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsernamePasswordDetailsService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private UserService userService;
    private TokenService tokenService;

    @Autowired
    public UsernamePasswordDetailsService(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.debug("Trying to authenticate ", email);
        try {
            return getUserDetails(userService.findByEmail(email));
        } catch (TokenCreationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private TokenUserDetails getUserDetails(User user) throws TokenCreationException {
        return new TokenUserDetails(
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                tokenService.encode(user),
                user.isEnabled(),
                getAuthorities(user.getRoles()));
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}