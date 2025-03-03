package com.mastercard.model.reference;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ref_limit")
public class RefLimit {
    @Id
    @Column(nullable = false)
    private Integer id;
    private String city;
    private String merchantCategory;
    private Integer limits;
}
