package com.mastercard.model.reference;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "ref_merchant_category")
public class RefMerchantCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer merchantCategoryId;
    private String merchantCategory;

    public Integer getMerchantCategoryId() {
        return merchantCategoryId;
    }

    public String getMerchantCategory() {
        return merchantCategory;
    }
}
