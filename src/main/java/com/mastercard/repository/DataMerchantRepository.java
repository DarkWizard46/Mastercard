package com.mastercard.repository;

import com.mastercard.model.data.DataMerchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataMerchantRepository extends JpaRepository<DataMerchant, Long> {
}
