package com.examplestudy.depotapp.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserDetailServiceImpl service;
    public UserController(UserDetailServiceImpl service){
        this.service = service;
    }
    @GetMapping("/moderators")
    @PreAuthorize("hasAuthority('admins')")
    public List<User> getAllModerators(){
        return service.getAllModerators();
    }
    @GetMapping("/moderators/{id}")
    @PreAuthorize("hasAuthority('admins')")
    public User getModeratorById(@PathVariable Long id){
        return service.getModerator(id);
    }
    @DeleteMapping("/moderators/{id}")
    @PreAuthorize("hasAuthority('admins')")
    public void deleteModeratorById(@PathVariable Long id){
        service.removeModerator(id);
    }
}
