package com.mastercard.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ActiveStatusConverter extends AttributeConverter<ActiveStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ActiveStatus status) {
        return status != null ? status.getValue() : null;
    }

    @Override
    public ActiveStatus convertToEntityAttribute(Integer value) {
        return value != null ? ActiveStatus.fromValue(value) : null;
    }
}
