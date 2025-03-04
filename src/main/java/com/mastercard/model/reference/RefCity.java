package com.mastercard.model.reference;

import com.mastercard.constant.ActiveStatus;
import com.mastercard.model.StatusConverter;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long cityId;

    private String city;
    @Column(nullable = false)
    @Convert(converter = StatusConverter.class)
    private ActiveStatus isActive;
}
