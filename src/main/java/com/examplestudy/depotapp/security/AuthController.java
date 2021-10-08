package com.examplestudy.depotapp.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/auth")
public class AuthController {
    private final UserDetailsServiceImpl service;
    public AuthController(UserDetailsServiceImpl service){
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
    public String getRegisterPage(){
        return "registration";
    }
   
}
