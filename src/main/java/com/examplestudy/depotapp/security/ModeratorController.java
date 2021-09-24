package com.examplestudy.depotapp.security;

import com.examplestudy.depotapp.security.UserDetailServiceImpl;
import com.examplestudy.depotapp.user.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModeratorController {
    private final UserDetailServiceImpl service;
    public ModeratorController(UserDetailServiceImpl service){
        this.service = service;
    }
    @GetMapping("/moderators")
    @PreAuthorize("hasAuthority('admins')")
    public List<User> getAllModerators(){
        return service.getAllModerators();
    }
    @PostMapping("/moderators")
    @PreAuthorize("hasAuthority('admins')")
    public void addModerator(@RequestBody User userData){
         service.addModerator(userData);
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
