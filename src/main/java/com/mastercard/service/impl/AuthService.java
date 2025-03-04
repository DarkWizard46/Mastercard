package com.mastercard.service.impl;

import com.mastercard.DTO.request.AuthRequest;
import com.mastercard.DTO.response.LoginResponse;

public interface AuthService {
//    RegisterResponse register (AuthRequest request);
    LoginResponse login (AuthRequest request);
}
