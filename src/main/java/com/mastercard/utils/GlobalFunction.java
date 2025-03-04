package com.mastercard.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastercard.handler.ResponseHandler;
import com.mastercard.model.data.DataMerchant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalFunction {
    public static ResponseEntity<Object> dataSaveFailed(String errorCode, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "DATA GAGAL DISIMPAN",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null,
                errorCode,
                request);
    }

    public static ResponseEntity<Object> contentTypeWorkBook (String errorCode, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "FORMAT FILE HARUS .XLSX",
                HttpStatus.BAD_REQUEST,
                null,
                errorCode, request);
    }

    public static ResponseEntity<Object> dataWorkBookEmpty (String errorCode, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "DATA FILE KOSONG",
                HttpStatus.BAD_REQUEST,
                null,
                errorCode, request);
    }

    public static ResponseEntity<Object> dataEditFailed (String errorCode, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "DATA GAGAL DIUBAH",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null,
                errorCode,
                request);
    }

    public static ResponseEntity<Object> cannotProcess (String errorCode, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "PERMINTAAN TIDAK DAPAT DIPROSES",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null,
                errorCode,
                request);
    }

    public static ResponseEntity<Object> dataNotFound (HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "DATA TIDAK DITEMUKAN",
                HttpStatus.BAD_REQUEST,
                null,
                "X-01-002",
                request);
    }

    /**
     * Digunakan untuk functional download file dll
     * yang bersifat tidak mengembalikan data response
     */
    public static void manualResponse (HttpServletResponse response, ResponseEntity<Object> respObject) {
        try {
            response.getWriter().write(convertObjectToJson(respObject.getBody()));
            response.setStatus(respObject.getStatusCodeValue());
        } catch (IOException e) {

        }
    }

    public static ResponseEntity<Object> dataFoundById (Object object, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "DATA DITEMUKAN",
                HttpStatus.OK,
                object,
                null,
                request);
    }

    public static ResponseEntity<Object> generatePaginationResponse (String message,
                                                                    HttpStatus status,
                                                                    Object responseObj,
                                                                    Map<String, Object> paginationInfo,
                                                                    HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj == null ? "" : responseObj);
        map.put("timestamp", new Date());
        map.put("success", !status.isError());

        if (paginationInfo != null) {
            map.put("pagination", paginationInfo); // Menambahkan info pagination
        }

        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Object> dataPagination (List<?> data, Page<?> pageData, HttpServletRequest request) {
        Map<String, Object> paginationInfo = new HashMap<>();
        paginationInfo.put("totalPages", pageData.getTotalPages());
        paginationInfo.put("totalElements", pageData.getTotalElements());
        paginationInfo.put("size", pageData.getSize());
        paginationInfo.put("number", pageData.getNumber());

        return generatePaginationResponse(
                "DATA DITEMUKAN",
                HttpStatus.OK,
                data, // This is the mapped List<RecruitmentResponse>
                paginationInfo,
                request);
    }

    public static ResponseEntity<Object> dataFoundAll (Object object, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "DATA DITEMUKAN",
                HttpStatus.OK,
                object,
                null,
                request);
    }

    public static ResponseEntity<Object> validationFailed (String message, String errorCode, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                message,
                HttpStatus.BAD_REQUEST,
                null,
                errorCode,
                request);
    }

    public static ResponseEntity<Object> dataSaved (HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "DATA BERHASIL DISIMPAN",
                HttpStatus.CREATED,
                null,
                null,
                request);
    }

    public static ResponseEntity<Object> dataEdited(HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "DATA BERHASIL DIUBAH",
                HttpStatus.OK,
                null,
                null,
                request);
    }

    public static ResponseEntity<Object> dataDeleted (HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "DATA BERHASIL DIHAPUS",
                HttpStatus.OK,
                null,
                null,
                request);
    }

    public static ResponseEntity<Object> getAllData (Page<DataMerchant> dataMerchants, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "DATA DITEMUKAN",
                HttpStatus.OK,
                dataMerchants.getContent(),
                Map.of(
                        "totalPages", dataMerchants.getTotalPages(),
                        "totalElements", dataMerchants.getTotalElements(),
                        "size", dataMerchants.getSize(),
                        "number", dataMerchants.getNumber()),
                request);
    }

    /**
     * Mengconvert Object java ke JSON
     */
    public static String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
