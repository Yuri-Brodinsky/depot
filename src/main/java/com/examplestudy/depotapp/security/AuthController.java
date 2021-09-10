package com.examplestudy.depotapp.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @PostMapping("/success")
    public String getSuccessPage(@RequestBody String username,@RequestBody String password){
        return "success";
    }
}