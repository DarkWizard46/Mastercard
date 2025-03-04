package com.mastercard.service;

import com.mastercard.config.OtherConfig;
import com.mastercard.model.data.DataMerchant;
import com.mastercard.core.IDataMerchantService;
import com.mastercard.repository.DataMerchantRepository;
import com.mastercard.utils.GlobalFunction;
import com.mastercard.utils.LoggingFile;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataMerchantService implements IDataMerchantService<DataMerchant> {
    @Autowired
    private DataMerchantRepository dataMerchantRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Object> getAll(HttpServletRequest request, int page, int size) {
        List<DataMerchant> dataMerchant = dataMerchantRepository.findAll();
        System.out.println("Get all Merchant" + Arrays.toString(dataMerchant.toArray()));
        Pageable pageable = PageRequest.of(page, size);
        Page<DataMerchant> roles = dataMerchantRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("size", roles.getSize());
        map.put("totalPages", roles.getTotalPages());
        map.put("totalElements", roles.getTotalElements());
        map.put("number", roles.getNumber());
        map.put("data", roles.getContent());
        return ResponseEntity.ok(map);
    }

    @Override
    @Transactional
    public ResponseEntity<Object> save (DataMerchant dataMerchant, HttpServletRequest request) {
        System.out.println("Saving...");
        System.out.println(dataMerchant);

        if (dataMerchant == null) {

            return GlobalFunction.validationFailed("OBJECT NULL", "FV001001001", request);
        }
        try {
            dataMerchantRepository.save(dataMerchant);
        } catch (Exception e) {
            LoggingFile.exceptionStringz("DataMerchantService", "save", e, OtherConfig.getFlagLogging());
            return GlobalFunction.dataSaveFailed("FE001001001", request);
        }
        return GlobalFunction.dataSaved(request);
    }

    @Override
    @Transactional
    public ResponseEntity<Object> update(Long merchantId, DataMerchant dataMerchant, HttpServletRequest request) {
        Optional<DataMerchant> optionalDataMerchant = dataMerchantRepository.findById(merchantId);

        if (optionalDataMerchant.isEmpty()) {
            return GlobalFunction.dataNotFound(request);
        }

        try {
            DataMerchant existingMerchant = optionalDataMerchant.get();

            // Update only non-null values
            if (dataMerchant.getBatch() != null) existingMerchant.setBatch(dataMerchant.getBatch());
            if (dataMerchant.getIdOld() != null) existingMerchant.setIdOld(dataMerchant.getIdOld());
            if (dataMerchant.getMid() != null) existingMerchant.setMid(dataMerchant.getMid());
            if (dataMerchant.getIdUpload() != null) existingMerchant.setIdUpload(dataMerchant.getIdUpload());
            if (dataMerchant.getMerchantName() != null) existingMerchant.setMerchantName(dataMerchant.getMerchantName());
            if (dataMerchant.getMerchantPICName() != null) existingMerchant.setMerchantPICName(dataMerchant.getMerchantPICName());
            if (dataMerchant.getMerchantCategory() != null) existingMerchant.setMerchantCategory(dataMerchant.getMerchantCategory());
            if (dataMerchant.getMerchantBusiness() != null) existingMerchant.setMerchantBusiness(dataMerchant.getMerchantBusiness());
            if (dataMerchant.getDeployetType() != null) existingMerchant.setDeployetType(dataMerchant.getDeployetType());
            if (dataMerchant.getPosDeployement() != null) existingMerchant.setPosDeployement(dataMerchant.getPosDeployement());
            if (dataMerchant.getEdcStatus() != null) existingMerchant.setEdcStatus(dataMerchant.getEdcStatus());
            if (dataMerchant.getPosmMerchant() != null) existingMerchant.setPosmMerchant(dataMerchant.getPosmMerchant());
            if (dataMerchant.getMailName() != null) existingMerchant.setMailName(dataMerchant.getMailName());
            if (dataMerchant.getAddress() != null) existingMerchant.setAddress(dataMerchant.getAddress());
            if (dataMerchant.getAddressDetail() != null) existingMerchant.setAddressDetail(dataMerchant.getAddressDetail());
            if (dataMerchant.getPic() != null) existingMerchant.setPic(dataMerchant.getPic());
            if (dataMerchant.getPicName() != null) existingMerchant.setPicName(dataMerchant.getPicName());
            if (dataMerchant.getPhoneNumber() != null) existingMerchant.setPhoneNumber(dataMerchant.getPhoneNumber());
            if (dataMerchant.getIsHaveEdc() != null) existingMerchant.setIsHaveEdc(dataMerchant.getIsHaveEdc());
            if (dataMerchant.getApplyEdc() != null) existingMerchant.setApplyEdc(dataMerchant.getApplyEdc());
            if (dataMerchant.getApplyEdcReason() != null) existingMerchant.setApplyEdcReason(dataMerchant.getApplyEdcReason());
            if (dataMerchant.getSalesCode() != null) existingMerchant.setSalesCode(dataMerchant.getSalesCode());
            if (dataMerchant.getSalesName() != null) existingMerchant.setSalesName(dataMerchant.getSalesName());
            if (dataMerchant.getCashierAwareness() != null) existingMerchant.setCashierAwareness(dataMerchant.getCashierAwareness());
            if (dataMerchant.getAwarenessReason() != null) existingMerchant.setAwarenessReason(dataMerchant.getAwarenessReason());
            if (dataMerchant.getWillingPlacePosm() != null) existingMerchant.setWillingPlacePosm(dataMerchant.getWillingPlacePosm());
            if (dataMerchant.getPlacedPosm() != null) existingMerchant.setPlacedPosm(dataMerchant.getPlacedPosm());
            if (dataMerchant.getNote() != null) existingMerchant.setNote(dataMerchant.getNote());
            if (dataMerchant.getValidationStatus() != null) existingMerchant.setValidationStatus(dataMerchant.getValidationStatus());
            if (dataMerchant.getValidationRemark() != null) existingMerchant.setValidationRemark(dataMerchant.getValidationRemark());
            if (dataMerchant.getValidationBy() != null) existingMerchant.setValidationBy(dataMerchant.getValidationBy());
            if (dataMerchant.getValidationNik() != null) existingMerchant.setValidationNik(dataMerchant.getValidationNik());
            if (dataMerchant.getValdiationDate() != null) existingMerchant.setValdiationDate(dataMerchant.getValdiationDate());
            if (dataMerchant.getMerchantConclusion() != null) existingMerchant.setMerchantConclusion(dataMerchant.getMerchantConclusion());
            if (dataMerchant.getVisitDate() != null) existingMerchant.setVisitDate(dataMerchant.getVisitDate());
            if (dataMerchant.getSubmitedDate() != null) existingMerchant.setSubmitedDate(dataMerchant.getSubmitedDate());
            if (dataMerchant.getModifiedBy() != null) existingMerchant.setModifiedBy(dataMerchant.getModifiedBy());
            if (dataMerchant.getHitCode() != null) existingMerchant.setHitCode(dataMerchant.getHitCode());
            if (dataMerchant.getGeoInfo() != null) existingMerchant.setGeoInfo(dataMerchant.getGeoInfo());
            if (dataMerchant.getGeoInfoAlamat() != null) existingMerchant.setGeoInfoAlamat(dataMerchant.getGeoInfoAlamat());
            if (dataMerchant.getZipCode1() != null) existingMerchant.setZipCode1(dataMerchant.getZipCode1());
            if (dataMerchant.getZipCode2() != null) existingMerchant.setZipCode2(dataMerchant.getZipCode2());
            if (dataMerchant.getIsZipCodeValid() != null) existingMerchant.setIsZipCodeValid(dataMerchant.getIsZipCodeValid());
            if (dataMerchant.getStatusPasang() != null) existingMerchant.setStatusPasang(dataMerchant.getStatusPasang());
            if (dataMerchant.getReasonGagalPasang() != null) existingMerchant.setReasonGagalPasang(dataMerchant.getReasonGagalPasang());
            if (dataMerchant.getStatusMerchant() != null) existingMerchant.setStatusMerchant(dataMerchant.getStatusMerchant());
            if (dataMerchant.getIsSameZipCode() != null) existingMerchant.setIsSameZipCode(dataMerchant.getIsSameZipCode());
            if (dataMerchant.getOldSticker() != null) existingMerchant.setOldSticker(dataMerchant.getOldSticker());
            if (dataMerchant.getIsCanvasing() != null) existingMerchant.setIsCanvasing(dataMerchant.getIsCanvasing());

            //Save changes to the database
            dataMerchantRepository.save(existingMerchant);

        } catch (Exception e) {
            LoggingFile.exceptionStringz("DataMerchantService", "update", e, OtherConfig.getFlagLogging());
            return GlobalFunction.dataEditFailed("FE002002011", request);
        }

        return GlobalFunction.dataEdited(request);
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        return GlobalFunction.dataFoundAll(dataMerchantRepository.findAll(), request);

    }

    @Override
    public ResponseEntity<Object> findById (Long dataMerchantId) {
        Optional<DataMerchant> dataMerchant = dataMerchantRepository.findById(dataMerchantId);
        System.out.println("in find by id " + dataMerchant.toString());

        if (dataMerchant.isPresent()) {
            return ResponseEntity.ok(dataMerchant.get());
        } else {
            return ResponseEntity.status(404).body("Merchant not found.");
        }
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String columnName, String value,
                                              HttpServletRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'findByParam'");
    }

    public boolean existsById(Long id) {
        return dataMerchantRepository.existsById(id);
    }
}
