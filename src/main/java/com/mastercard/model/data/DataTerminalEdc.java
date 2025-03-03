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
@Table(name = "data_terminal_edc")
public class DataTerminalEdc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer terminalId;
    @Column(nullable = false)
    private Integer merchantId;
    private String tid;
    private String edcTest;
    private String edcIssue;
    private String fotoEdc;
    private String fotoStruk;
    @CurrentTimestamp
    @Column(name = "Created_Date")
    private Date createdDate;
    private Date modifiedDate;
}
