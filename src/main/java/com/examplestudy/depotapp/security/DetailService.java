package com.examplestudy.depotapp.security;

import com.examplestudy.depotapp.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DetailService implements UserDetailsService {
    private final UserRepository repository;
    public DetailService(UserRepository repository){
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       return repository.findByLogin(login);
    }
}
