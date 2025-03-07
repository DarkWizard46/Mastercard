package com.mastercard.service.impl;

import com.mastercard.DTO.request.UserRequest;
import com.mastercard.model.users.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService<T> extends UserDetailsService {
    ResponseEntity<Object> getAll(HttpServletRequest request, int page, int size);

    @Transactional
    ResponseEntity<Object> save(@Valid UserRequest userRequest, HttpServletRequest request);

    @Transactional
    ResponseEntity<Object> update(Long id, User user, HttpServletRequest request);

    ResponseEntity<Object> delete(Long id, HttpServletRequest request);

//    ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request);

//    ResponseEntity<Object> findById (Long id);// 041-050

    ResponseEntity<Object> findByParam(Pageable pageable, String columnName, String value,
                                              HttpServletRequest request);

    boolean existsById(Long id);
}
