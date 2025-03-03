package com.mastercard.model.data;

import com.mastercard.model.ActiveStatus;
import com.mastercard.model.ActiveStatusConverter;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "data_merchant_delete")
public class DataMerchantDelete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long merchantId;

    private Integer mid;
    private String merchantName;
    private String merchantCategory;
    private String posmMerchant;
    private String mailName;
    private String address;
    private String addressDetail;
    private String city;
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
    @Convert(converter = ActiveStatusConverter.class)
    private ActiveStatus isZipCodeValid;
}
