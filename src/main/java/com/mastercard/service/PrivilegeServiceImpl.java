package com.mastercard.service;

import com.mastercard.constant.UserPrivilege;
import com.mastercard.model.users.Privilege;
import com.mastercard.repository.PrivilegeRepository;
import com.mastercard.service.impl.PrivilegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PrivilegeServiceImpl implements PrivilegeService {

    private final PrivilegeRepository privilegeRepository;

    @Override
    @Transactional
    public Privilege getOrSave(UserPrivilege privilege) {
        return privilegeRepository.findByPrivilegeDesc(privilege.name())
                .orElseGet(() -> privilegeRepository.saveAndFlush(
                        Privilege.builder().privilegeDesc(privilege.name()).build()));
    }


}
