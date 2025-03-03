package com.mastercard.model.data;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "data_photo")
public class DataPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer merchantPhotoId;
    @Column(nullable = false)
    private Integer merchantId;
    @Column(nullable = false)
    private Integer photoId;
    private String photoCategory;
    private String fileName;
    private String geoInfo;
    private String typeUpload;
    @CurrentTimestamp
    @Column(name = "Created_Date")
    private Date createdDate;
}
