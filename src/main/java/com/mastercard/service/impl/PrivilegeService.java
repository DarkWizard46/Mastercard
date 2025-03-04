package com.mastercard.service.impl;

import com.mastercard.constant.UserPrivilege;
import com.mastercard.model.users.Privilege;

public interface PrivilegeService {
    Privilege getOrSave (UserPrivilege privilege);
}
