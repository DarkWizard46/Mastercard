package com.mastercard.service.impl;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Object getByUserId (Long id);
}
