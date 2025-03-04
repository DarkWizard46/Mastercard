package com.mastercard.model;

import com.mastercard.constant.Status;

import java.util.List;

public class ActiveStatus {
    NO(0), YES(1);

    private final int value;
    private List<Status> status;

    ActiveStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ActiveStatus fromValue(int value) {
        for (ActiveStatus status : ActiveStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value for ActiveStatus: " + value);
    }
}
