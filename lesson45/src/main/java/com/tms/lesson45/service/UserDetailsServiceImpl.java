package com.tms.lesson45.service;

import com.tms.lesson45.model.Role;
import com.tms.lesson45.model.User;
import com.tms.lesson45.model.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;   //Parameter 0 of constructor in com.tms.lesson45.service.UserDetailsServiceImpl required a bean of type 'repository.UserRepository' that could not be found.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getByLogin(username);
        List<Role> roles = user.getRoles();
        List<String> rolesAsString = roles.stream()
                .map(Role::getName)
                .collect(Collectors.toList());
        return new UserSecurity(user.getLogin(), user.getPassword(), rolesAsString);
    }
}
