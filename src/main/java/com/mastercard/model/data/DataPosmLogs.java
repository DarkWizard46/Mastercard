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
@Table(name = "data_posm_logs")
public class DataPosmLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer logId;
    private Integer posmId;
    private Integer stock;
    @CurrentTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;
    private String updatedBy;
}
