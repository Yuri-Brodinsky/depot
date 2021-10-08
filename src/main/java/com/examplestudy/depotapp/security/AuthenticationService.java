package com.examplestudy.depotapp.security;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsServiceImpl userDetailService;

    public AuthenticationService(AuthenticationManager authenticationManager,
                                 JwtTokenProvider jwtTokenProvider, UserDetailsServiceImpl userDetailService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailService = userDetailService;
    }
    public ResponseEntity<?> authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(),
                        authenticationRequest.getPassword()));
        UserDetails user = userDetailService.loadUserByUsername(authenticationRequest.getLogin());
        String token = jwtTokenProvider.createToken(user.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
    public void logout(HttpServletRequest request, HttpServletResponse response){
        SecurityContextLogoutHandler handler = new SecurityContextLogoutHandler();
        handler.logout(request,response,null);
    }
}
