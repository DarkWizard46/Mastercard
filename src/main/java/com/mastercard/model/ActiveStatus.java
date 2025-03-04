package com.mastercard.constant;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum ActiveStatus {
    ACTIVE,
    DEACTIVE;

    public static ActiveStatus fromString(String value) {
        for (ActiveStatus status : ActiveStatus.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value for ActiveStatus: " + value);
    }
}
