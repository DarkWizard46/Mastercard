package com.mastercard.model.reference;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ref_merchant_category")
public class RefMerchantCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer merchantCategoryId;
    private String merchantCategory;
}
