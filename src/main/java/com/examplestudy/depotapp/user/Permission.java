package com.examplestudy.depotapp.user;

public enum Permission {
    CLIENTS_READ("clients:read"),
    CLIENTS_WRITE("clients:write"),
    DEPOT("depot");
    private final String permission;
    Permission(String permission){
        this.permission = permission;
    }
    public String getPermission(){
        return permission;
    }
}
