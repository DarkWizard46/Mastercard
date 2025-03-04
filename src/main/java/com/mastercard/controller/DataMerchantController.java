package com.mastercard.controller;

import com.mastercard.model.data.DataMerchant;
import com.mastercard.service.DataMerchantService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/merchant")
@Component
public class DataMerchantController {
    @Autowired
    private DataMerchantService dataMerchantService;

    private Map<String, Object> mapSorting = new HashMap<>();

    private void mapSorting() {
        mapSorting.put("name", "group");
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllMerchants(
            HttpServletRequest request,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return dataMerchantService.getAll(request, page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMerchantById(@PathVariable Long id) {
        return dataMerchantService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> createMerchant(
            @RequestBody DataMerchant dataMerchant,
            HttpServletRequest request) {
        return dataMerchantService.save(dataMerchant, request);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchMerchant(
            @RequestParam String columnName,
            @RequestParam String value,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest request) {
        Pageable pageable = PageRequest.of(page, size);
        return dataMerchantService.findByParam(pageable, columnName, value, request);
    }
}
