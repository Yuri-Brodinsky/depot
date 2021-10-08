package com.examplestudy.depotapp.security;


import com.examplestudy.depotapp.user.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/registration")
public class RegistrationController {
    private final UserDetailsServiceImpl service;
    public RegistrationController(UserDetailsServiceImpl service){
        this.service = service;
    }
    @GetMapping("/moderators")
    @PreAuthorize("hasAuthority('admins')")
    public List<User> getAllModerators(){
        return service.getAllModerators();
    }
    @PostMapping("/moderators")
    @PreAuthorize("hasAuthority('admins')")
    public void addModerator(@RequestBody AuthenticationRequest request){
         service.addModerator(request);
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
    @PostMapping("/moderators")
    public void addUser(@RequestBody AuthenticationRequest request){
        service.addUser(request);
    }
}
