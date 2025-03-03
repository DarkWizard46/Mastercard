package com.mastercard.service;

import com.mastercard.model.data.DataMerchant;
import com.mastercard.repository.DataMerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataMerchantService {
    @Autowired
    private DataMerchantRepository dataMerchantRepository;

    public DataMerchantService(DataMerchantRepository dataMerchantRepository) {
        this.dataMerchantRepository = dataMerchantRepository;
    }

    public Optional<DataMerchant> findByMerchantId(Integer merchantId) {
        return dataMerchantRepository.findByMerchantId(merchantId);
    }
    public Optional<DataMerchant> findByMerchantName(String merchantName) {
        return dataMerchantRepository.findByMerchantName(merchantName);
    }
}
