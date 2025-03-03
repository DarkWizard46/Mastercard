package com.mastercard.controller;

import com.mastercard.model.users.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final com.mastercard.service.UsersServiceImpl userService;
    private final AuthenticationManager authenticationManager;

    public AuthController(com.mastercard.service.UsersServiceImpl userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("User logged in successfully");
    }
}
