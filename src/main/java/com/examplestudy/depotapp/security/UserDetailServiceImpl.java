package com.examplestudy.depotapp.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    public UserDetailServiceImpl(UserRepository repository){
        this.repository = repository;
        passwordEncoder = new BCryptPasswordEncoder(12);
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repository.findByLogin(login);
        UserDetails securityUser = SecurityUser.userDetailsFromUser(user);
       return securityUser;
    }
    public boolean addUser( User userData){
        User user = new User();
        User res = repository.findByLogin(userData.getLogin());
        if(res==null){
        user.setLogin(userData.getLogin());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        user.setRole(Role.USER);
        repository.save(user);
        return true;
        }
        return false;
    }
    public boolean addModerator( User userData){
        User user = new User();
        User res = repository.findByLogin(userData.getLogin());
        if(res==null){
            user.setLogin(userData.getLogin());
            user.setPassword(passwordEncoder.encode(userData.getPassword()));
            user.setRole(Role.MODERATOR);
            repository.save(user);
            return true;
        }
        return false;
    }
    public void removeModerator(Long id){
        repository.deleteById(id);
    }
    public List<User> getAllModerators(){
        return repository.findByRole(Role.MODERATOR);
    }
    public User getModerator(Long id){
        User user = repository.findById(id).get();
        if(user.getRole()==Role.MODERATOR) return user;
        return null;
    }
}
