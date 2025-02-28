package com.mastercard.model.datamerchant;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name = "data_merchant")
public class DataMerchant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer merchantId;

    private Integer batch;
    private Integer idOld;
    private String mid;
    private Integer idUpload;
    private String merchantName;
    private String merchantPICName;
    private String merchantCategory;
    private String merchantBusiness;
    private String deployetType;
    private String posDeployement;
    private String edcStatus;
    private String posmMerchant;
    private String mailName;
    private String address;
    private String addressDetail;
    private String pic;
    private String picName;
    private String phoneNumber;
    private String isHaveEdc;
    private String applyEdc;
    private String applyEdcReason;
    private String salesCode;
    private String salesName;
    private String cashierAwareness;
    private String awarenessReason;
    private String willingPlacePosm;
    private String placedPosm;
    private String note;
    private String validationStatus;
    private String validationRemark;
    private String validationBy;
    private String validationNik;
    private Date valdiationDate;
    private String merchantConclusion;
    @CurrentTimestamp
    @Column(name = "Visit_Date")
    private Date visitDate;
    private Date submitedDate;
    private String modifiedBy;
    @UpdateTimestamp
    @Column(name = "Modified_Date")
    private Date modifiedDate;
    private Integer hitCode;
    private String geoInfo;
    private String geoInfoAlamat;
    private String zipCode1;
    private String zipCode2;
    @Column(nullable = false)
    private Integer isZipCodeValid;
    private String statusPasang;
    private String reasonGagalPasang;
    private String statusMerchant;
    private String isSameZipCode;
    private String oldSticker;
    private Integer isCanvasing;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public Integer getIdOld() {
        return idOld;
    }

    public void setIdOld(Integer idOld) {
        this.idOld = idOld;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getIdUpload() {
        return idUpload;
    }

    public void setIdUpload(Integer idUpload) {
        this.idUpload = idUpload;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantPICName() {
        return merchantPICName;
    }

    public void setMerchantPICName(String merchantPICName) {
        this.merchantPICName = merchantPICName;
    }

    public String getMerchantCategory() {
        return merchantCategory;
    }

    public void setMerchantCategory(String merchantCategory) {
        this.merchantCategory = merchantCategory;
    }

    public String getMerchantBusiness() {
        return merchantBusiness;
    }

    public void setMerchantBusiness(String merchantBusiness) {
        this.merchantBusiness = merchantBusiness;
    }

    public String getDeployetType() {
        return deployetType;
    }

    public void setDeployetType(String deployetType) {
        this.deployetType = deployetType;
    }

    public String getPosDeployement() {
        return posDeployement;
    }

    public void setPosDeployement(String posDeployement) {
        this.posDeployement = posDeployement;
    }

    public String getEdcStatus() {
        return edcStatus;
    }

    public void setEdcStatus(String edcStatus) {
        this.edcStatus = edcStatus;
    }

    public String getPosmMerchant() {
        return posmMerchant;
    }

    public void setPosmMerchant(String posmMerchant) {
        this.posmMerchant = posmMerchant;
    }

    public String getMailName() {
        return mailName;
    }

    public void setMailName(String mailName) {
        this.mailName = mailName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIsHaveEdc() {
        return isHaveEdc;
    }

    public void setIsHaveEdc(String isHaveEdc) {
        this.isHaveEdc = isHaveEdc;
    }

    public String getApplyEdc() {
        return applyEdc;
    }

    public void setApplyEdc(String applyEdc) {
        this.applyEdc = applyEdc;
    }

    public String getApplyEdcReason() {
        return applyEdcReason;
    }

    public void setApplyEdcReason(String applyEdcReason) {
        this.applyEdcReason = applyEdcReason;
    }

    public String getSalesCode() {
        return salesCode;
    }

    public void setSalesCode(String salesCode) {
        this.salesCode = salesCode;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getCashierAwareness() {
        return cashierAwareness;
    }

    public void setCashierAwareness(String cashierAwareness) {
        this.cashierAwareness = cashierAwareness;
    }

    public String getAwarenessReason() {
        return awarenessReason;
    }

    public void setAwarenessReason(String awarenessReason) {
        this.awarenessReason = awarenessReason;
    }

    public String getWillingPlacePosm() {
        return willingPlacePosm;
    }

    public void setWillingPlacePosm(String willingPlacePosm) {
        this.willingPlacePosm = willingPlacePosm;
    }

    public String getPlacedPosm() {
        return placedPosm;
    }

    public void setPlacedPosm(String placedPosm) {
        this.placedPosm = placedPosm;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(String validationStatus) {
        this.validationStatus = validationStatus;
    }

    public String getValidationRemark() {
        return validationRemark;
    }

    public void setValidationRemark(String validationRemark) {
        this.validationRemark = validationRemark;
    }

    public String getValidationBy() {
        return validationBy;
    }

    public void setValidationBy(String validationBy) {
        this.validationBy = validationBy;
    }

    public String getValidationNik() {
        return validationNik;
    }

    public void setValidationNik(String validationNik) {
        this.validationNik = validationNik;
    }

    public Date getValdiationDate() {
        return valdiationDate;
    }

    public void setValdiationDate(Date valdiationDate) {
        this.valdiationDate = valdiationDate;
    }

    public String getMerchantConclusion() {
        return merchantConclusion;
    }

    public void setMerchantConclusion(String merchantConclusion) {
        this.merchantConclusion = merchantConclusion;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getSubmitedDate() {
        return submitedDate;
    }

    public void setSubmitedDate(Date submitedDate) {
        this.submitedDate = submitedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getHitCode() {
        return hitCode;
    }

    public void setHitCode(Integer hitCode) {
        this.hitCode = hitCode;
    }

    public String getGeoInfo() {
        return geoInfo;
    }

    public void setGeoInfo(String geoInfo) {
        this.geoInfo = geoInfo;
    }

    public String getGeoInfoAlamat() {
        return geoInfoAlamat;
    }

    public void setGeoInfoAlamat(String geoInfoAlamat) {
        this.geoInfoAlamat = geoInfoAlamat;
    }

    public String getZipCode1() {
        return zipCode1;
    }

    public void setZipCode1(String zipCode1) {
        this.zipCode1 = zipCode1;
    }

    public String getZipCode2() {
        return zipCode2;
    }

    public void setZipCode2(String zipCode2) {
        this.zipCode2 = zipCode2;
    }

    public Integer getIsZipCodeValid() {
        return isZipCodeValid;
    }

    public void setIsZipCodeValid(Integer isZipCodeValid) {
        this.isZipCodeValid = isZipCodeValid;
    }

    public String getStatusPasang() {
        return statusPasang;
    }

    public void setStatusPasang(String statusPasang) {
        this.statusPasang = statusPasang;
    }

    public String getReasonGagalPasang() {
        return reasonGagalPasang;
    }

    public void setReasonGagalPasang(String reasonGagalPasang) {
        this.reasonGagalPasang = reasonGagalPasang;
    }

    public String getStatusMerchant() {
        return statusMerchant;
    }

    public void setStatusMerchant(String statusMerchant) {
        this.statusMerchant = statusMerchant;
    }

    public String getIsSameZipCode() {
        return isSameZipCode;
    }

    public void setIsSameZipCode(String isSameZipCode) {
        this.isSameZipCode = isSameZipCode;
    }

    public String getOldSticker() {
        return oldSticker;
    }

    public void setOldSticker(String oldSticker) {
        this.oldSticker = oldSticker;
    }

    public Integer getIsCanvasing() {
        return isCanvasing;
    }

    public void setIsCanvasing(Integer isCanvasing) {
        this.isCanvasing = isCanvasing;
    }
}
