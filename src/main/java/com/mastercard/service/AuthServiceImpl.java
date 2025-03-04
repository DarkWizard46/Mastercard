package com.mastercard.service;

import com.mastercard.DTO.request.AuthRequest;
import com.mastercard.DTO.response.LoginResponse;
import com.mastercard.constant.UserPrivilege;
import com.mastercard.model.users.Privilege;
import com.mastercard.model.users.User;
import com.mastercard.repository.UserRepository;
import com.mastercard.service.impl.AuthService;
import com.mastercard.service.impl.JwtService;
import com.mastercard.service.impl.PrivilegeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final UserRepository userRepository;
    private final PrivilegeService privilegeService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Value("${app.management.username-admin}")
    private String AdminUsername;

    @Value("${app.management.password-admin}")
    private String AdminPassword;

    @Transactional(rollbackFor = Exception.class)
    @PostConstruct
    public void initialSuperAdmin() {
        Optional<User> currentAccount = userRepository.findByUsername(AdminUsername);
        if (currentAccount.isPresent()) {
            LOGGER.info("Superadmin '{}' already exists.", AdminUsername);
            return;
        }

        Privilege superadmin = privilegeService.getOrSave(UserPrivilege.SUPERADMIN);
        Privilege adminBD = privilegeService.getOrSave(UserPrivilege.ADMIN_BD);
        Privilege md = privilegeService.getOrSave(UserPrivilege.MD);
        Privilege leaderMD = privilegeService.getOrSave(UserPrivilege.LEADER_MD);
        Privilege adminValidator = privilegeService.getOrSave(UserPrivilege.ADMIN_VALIDATOR);
        Privilege leaderValidator = privilegeService.getOrSave(UserPrivilege.LEADER_VALIDATOR);

        User user = User.builder()
                .username(AdminUsername)
                .password(passwordEncoder.encode(AdminPassword))
                .privilege(List.of(superadmin, adminBD, md, leaderMD, adminValidator, leaderValidator)) // ✅ Ganti `role` jadi `privilege`
                .isEnable(true)
                .build();

        userRepository.save(user);
        LOGGER.info("Superadmin '{}' has been created successfully.", AdminUsername);
    }

    @Override
    public LoginResponse login(AuthRequest request) {
        User authenticatedUser = authenticateUser(request.getUsername(), request.getPassword());

        String token = jwtService.generateToken(authenticatedUser);

        return LoginResponse.builder()
                .token(token)
                .username(authenticatedUser.getUsername())
                .privilege(authenticatedUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList()) // ✅ Gunakan `privilege()`
                .build();
    }

    private User authenticateUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        return (User) authentication.getPrincipal();
    }
}
