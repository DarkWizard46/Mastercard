package com.mastercard.model.reference;

import com.mastercard.constant.ActiveStatus;
import com.mastercard.model.StatusConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ref_reason")
public class RefReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long reasonId;

    private String reason;
    @Column(nullable = false)
    @Convert(converter = StatusConverter.class)
    private ActiveStatus isActive;
    private String createdBy;
    @Column(name = "created_date")
    private Date createdDate;
    private String modifiedBy;
    @Column(name = "modified_date")
    private Date modifiedDate;

}
