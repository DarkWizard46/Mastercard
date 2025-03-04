package com.mastercard.service.impl;

import com.mastercard.model.users.Privilege;
import com.mastercard.model.users.User;

import java.util.List;

public interface JwtService {
    String generateToken(User users); // Generate token berdasarkan user

    boolean verifyJwtToken(String token); // Verifikasi token JWT

    String getUsernameFromToken(String token); // Ambil username dari token

    List<Privilege> getPrivilegeFromToken(String token); // Ambil daftar role dari token
}
