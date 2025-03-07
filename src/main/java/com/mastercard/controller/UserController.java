package com.mastercard.controller;

import com.mastercard.DTO.request.UserRequest;
import com.mastercard.service.impl.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/master")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Object> getAll(HttpServletRequest request,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        return userService.getAll(request, page, size);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> save(@Valid @RequestBody UserRequest userRequest,
                                       HttpServletRequest request) {
        return userService.save(userRequest, request);
    }
}
