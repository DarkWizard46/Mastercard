package com.mastercard.service;

import com.mastercard.DTO.request.UserRequest;
import com.mastercard.model.users.User;
import com.mastercard.service.impl.UserService;
import com.mastercard.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<Object> getAll(HttpServletRequest request, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userRepository.findAll(pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("size", users.getSize());
        response.put("totalPages", users.getTotalPages());
        response.put("totalElements", users.getTotalElements());
        response.put("number", users.getNumber());
        response.put("data", users.getContent());
        return ResponseEntity.ok(response);
    }

    @Override
    @Transactional
    public ResponseEntity<Object> save(@Valid UserRequest userRequest, HttpServletRequest request) {
        User user = User.builder()
                .nik(userRequest.getNik())
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .name(userRequest.getName())
                .build();
        try {
            User savedUser = userRepository.save(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            LOGGER.error("Error saving user: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save user");
        }
    }

    @Transactional
    @Override
    public ResponseEntity<Object> update(Long id, User user, HttpServletRequest request) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        try {
            User existingUser = optionalUser.get();
            if (user.getNik() != null) existingUser.setNik(user.getNik());
            if (user.getName() != null) existingUser.setName(user.getName());
            if (user.getUsername() != null) existingUser.setUsername(user.getUsername());
            if (user.getStatus() != null) existingUser.setStatus(user.getStatus());
            if (user.getPrivilege() != null) existingUser.setPrivilege(user.getPrivilege());

            userRepository.save(existingUser);
            return ResponseEntity.ok(existingUser);
        } catch (Exception e) {
            LOGGER.error("Error updating user: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user");
        }
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String columnName, String value, HttpServletRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'findByParam'");
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}