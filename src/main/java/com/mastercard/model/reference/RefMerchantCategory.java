package com.mastercard.model.reference;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "ref_merchant_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefMerchantCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer merchantCategoryId;
    private String merchantCategory;
}
