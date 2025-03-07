package com.mastercard.controller;

import com.mastercard.DTO.request.AuthRequest;
import com.mastercard.DTO.response.CommonResponse;
import com.mastercard.DTO.response.LoginResponse;
import com.mastercard.service.impl.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<LoginResponse>> login(@RequestBody AuthRequest request) {
        System.out.println("Login request received: " + request.getUsername());
        LoginResponse loginResponse = authService.login(request);

        return ResponseEntity.ok(
                CommonResponse.<LoginResponse>builder()
                        .statusCode(HttpStatus.ACCEPTED.value())
                        .message("You have successfully logged in")
                        .data(loginResponse)
                        .build()
        );
    }
}
