package com.mastercard.model.reference;

import com.mastercard.model.ActiveStatus;
import com.mastercard.model.ActiveStatusConverter;
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
@Table(name = "ref_reason")
public class RefReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer reasonId;
    private String reason;
    @Column(nullable = false)
    @Convert(converter = ActiveStatusConverter.class)
    private ActiveStatus isActive;
    private String createdBy;
    @Column(name = "created_date")
    private Date createdDate;
    private String modifiedBy;
    @Column(name = "modified_date")
    private Date modifiedDate;

}
