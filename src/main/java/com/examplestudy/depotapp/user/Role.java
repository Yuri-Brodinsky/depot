package com.examplestudy.depotapp.user;

import java.util.Set;

public enum Role {
    USER(Set.of(Permission.CLIENTS_READ,Permission.CLIENTS_WRITE)),
    ADMIN(Set.of(Permission.CLIENTS_READ,Permission.DEPOT));
    private final Set<Permission> permissions;
    Role(Set<Permission> permissions){
        this.permissions = permissions;
    }

}
