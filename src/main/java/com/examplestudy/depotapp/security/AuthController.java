package com.examplestudy.depotapp.security;

import com.examplestudy.depotapp.user.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserDetailServiceImpl service;
    public AuthController(UserDetailServiceImpl service){
        this.service = service;
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/success")
    public String getSuccessPage(){
        return "success";
    }
    @GetMapping("/registration")
    public String getRegisterPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user,Model model){
        boolean b = service.addUser(user);
        if(!b) {
            model.addAttribute("error","user with the same login already exist");
            return "/registration";
        }
        return "login";
    }
   
}
