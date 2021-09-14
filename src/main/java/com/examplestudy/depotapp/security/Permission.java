package com.examplestudy.depotapp.security;

public enum Permission {
    CLIENTS("clients"),
    DEPOT("depot"),
    ADMINS("admins");
    private final String permission;
    Permission(String permission){
        this.permission = permission;
    }
    public String getPermission(){
        return permission;
    }
}
