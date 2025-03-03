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
@Table(name = "data_process_logs")
public class DataProcessLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer logId;
    private Integer merchantId;
    private Integer hitCode;
    private String remark;
    @CurrentTimestamp
    @Column(name = "Updated_Date")
    private Date updatedDate;
    private String updatedBy;
}
