package com.mastercard.service;

import com.mastercard.model.users.Users;
import com.mastercard.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users registerUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPrivilege(Integer.valueOf("USER"));
        return usersRepository.save(user);
    }

    public Optional<Users> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}