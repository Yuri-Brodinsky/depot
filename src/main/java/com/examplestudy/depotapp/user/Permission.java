package com.examplestudy.depotapp.user;

public enum Permission {
    CLIENTS("clients"),
    DEPOT("depot");
    private final String permission;
    Permission(String permission){
        this.permission = permission;
    }
    public String getPermission(){
        return permission;
    }
}
