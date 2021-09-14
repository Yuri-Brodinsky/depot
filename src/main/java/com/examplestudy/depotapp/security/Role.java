package com.examplestudy.depotapp.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.CLIENTS)),
    ADMIN(Set.of(Permission.DEPOT,Permission.ADMINS)),
    MODERATOR(Set.of(Permission.DEPOT));
    private final Set<Permission> permissions;
    Role(Set<Permission> permissions){
        this.permissions = permissions;
    }
    public Set<SimpleGrantedAuthority> getAuthority(){
        return permissions.stream()
                .map(p->new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toSet());

    }

}
