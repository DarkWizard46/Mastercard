package com.mastercard.model.reference;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ref_mall")
public class RefMall {
    @Id
    @Column(nullable = false)
    private Integer mallId;
    private String mallName;
    private String city;
    private String zipCode;
}
