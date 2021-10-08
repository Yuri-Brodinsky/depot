package com.examplestudy.depotapp.security;

import com.examplestudy.depotapp.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
public class UserDetailsImpl implements UserDetails {
    private final Long id;
    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;
    private final boolean isActive;
    public UserDetailsImpl(Long id, String username, String password,
                           List<GrantedAuthority> authorities, boolean isActive){
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
    public static UserDetails userDetailsFromUser(User user){
        return new UserDetailsImpl(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                new ArrayList<>(user.getRole().getAuthority()),
                true

        );
    }
}
