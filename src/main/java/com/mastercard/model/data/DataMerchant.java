package com.mastercard.model.data;

import com.mastercard.constant.ActiveStatus;
import com.mastercard.model.StatusConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "data_merchant")
public class DataMerchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long merchantId;

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
    @Column(name = "Visit_Date", nullable=false)
    private Date visitDate;
    @Column(name = "Submited_Date", nullable=false)
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
    @Convert(converter = StatusConverter.class)
    private ActiveStatus isZipCodeValid;
    private String statusPasang;
    private String reasonGagalPasang;
    private String statusMerchant;
    private String isSameZipCode;
    private String oldSticker;
    private Integer isCanvasing;
}
