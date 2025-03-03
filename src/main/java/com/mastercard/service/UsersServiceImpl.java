package com.mastercard.service;

import com.mastercard.model.users.Users;
import com.mastercard.service.impl.UserService;
import com.mastercard.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }
//
//    public Users registerUser(Users user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setPrivilege(Integer.valueOf("USER"));
//        return usersRepository.save(user);
//    }
//
//    public Optional<Users> findByUsername(String username) {
//        return usersRepository.findByUsername(username);
//    }

    @Override
    public Users getUsers(String Id) {
        return null;
    }
}