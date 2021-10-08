package com.examplestudy.depotapp.security;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationRestController {

    private final AuthenticationService service;

    public AuthenticationRestController(AuthenticationService service){
        this.service = service;
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return service.authenticate(authenticationRequest);
    }
    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        service.logout(request,response);
    }
}
