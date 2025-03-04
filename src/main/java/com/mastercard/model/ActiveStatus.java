package com.mastercard.model;

public enum ActiveStatus {
    NO(0), YES(1);

    private final int value;

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
