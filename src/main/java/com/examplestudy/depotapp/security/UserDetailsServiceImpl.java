package com.examplestudy.depotapp.security;

import com.examplestudy.depotapp.response.AlreadyExistException;
import com.examplestudy.depotapp.response.NotFoundException;
import com.examplestudy.depotapp.user.User;
import com.examplestudy.depotapp.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository repository){
        this.repository = repository;
        passwordEncoder = new BCryptPasswordEncoder(12);

    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repository.findByLogin(login);
        UserDetails securityUser = UserDetailsImpl.userDetailsFromUser(user);
       return securityUser;
    }
    public void addUser( AuthenticationRequest request){
        User user = new User();
        User res = repository.findByLogin(request.getLogin());
        if(res==null){
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        repository.save(user);

        }
        else throw new AlreadyExistException("this login is busy");

    }
    public void addModerator( AuthenticationRequest request){
        User user = new User();
        User res = repository.findByLogin(request.getLogin());
        if(res==null){
            user.setLogin(request.getLogin());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRole(Role.MODERATOR);
            repository.save(user);
        }
        else throw new AlreadyExistException("this login is busy");
    }
    public void removeModerator(Long id){
        repository.deleteById(id);
    }
    public List<User> getAllModerators(){
        return repository.findByRole(Role.MODERATOR);
    }
    public User getModerator(Long id){
        User user = repository.findById(id).get();
        if(user==null) throw new NotFoundException("this moderator was not found");
        if(user.getRole()==Role.MODERATOR) return user;
        return null;
    }

}
