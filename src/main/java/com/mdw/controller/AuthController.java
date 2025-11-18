package com.mdw.controller;

import com.mdw.model.LoginRequest;
import com.mdw.service.JwtUtils;
import com.mdw.service.CustomUserDetailsService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    //GESTOR DE AUTORIZACIÓN
    private final AuthenticationManager authenticationManager;
    
    @Autowired
    private final CustomUserDetailsService userDetailsService; 
    private final JwtUtils jwtUtils;

    //CONSTRUCTOR
    public AuthController(
        AuthenticationManager authenticationManager,
        CustomUserDetailsService userDetailsService, 
        JwtUtils jwtUtils
    ) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        //VERIFICA TOKEN
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        String token = jwtUtils.generateToken(request.getUsername());
        return ResponseEntity.ok(token);
    }
}