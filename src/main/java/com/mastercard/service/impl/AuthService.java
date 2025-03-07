package com.mastercard.service.impl;

import com.mastercard.DTO.request.AuthRequest;
import com.mastercard.DTO.response.LoginResponse;

public interface AuthService {
    LoginResponse login (AuthRequest request);
}
