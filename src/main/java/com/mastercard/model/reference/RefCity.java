package com.mastercard.model.reference;

import com.mastercard.model.ActiveStatus;
import com.mastercard.model.ActiveStatusConverter;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ref_city")
public class RefCity {
    @Id
    @Column(nullable = false)
    private Integer cityId;
    private String city;
    @Column(nullable = false)
    @Convert(converter = ActiveStatusConverter.class)
    private ActiveStatus isActive;
}
