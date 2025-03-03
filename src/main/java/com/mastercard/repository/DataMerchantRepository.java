package com.mastercard.repository;

import com.mastercard.model.data.DataMerchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DataMerchantRepository extends JpaRepository<DataMerchant, Integer> {
    Optional<DataMerchant> findByMerchantId(Integer merchantId);
    Optional<DataMerchant> findByMerchantName(String merchantName);
}
