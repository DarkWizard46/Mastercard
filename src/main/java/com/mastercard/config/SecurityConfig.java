package com.mastercard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.lang.NonNull;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF untuk API
                .cors(cors -> cors.configure(http)) // Aktifkan CORS
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // Izinkan akses tanpa login ke /public/**
                        .anyRequest().authenticated() // Selain itu, perlu autentikasi
                )
                .formLogin(withDefaults()); // Gunakan default login page
        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) { // Tambahkan @NonNull
                registry.addMapping("/**") // Izinkan semua endpoint diakses
                        .allowedOrigins("http://localhost:3000", "http://localhost:8080") // URL frontend React.js
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Method yang diizinkan
                        .allowedHeaders("*") // Semua header diperbolehkan
                        .allowCredentials(true); // Izinkan kredensial (misalnya cookie atau Authorization header)
            }
        };
    }
}
