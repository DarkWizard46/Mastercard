package com.mastercard.model.reference;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.data.annotation.Id;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Entity
@Table(name = "ref_lob")
public class RefLob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    private String lob;
    private String createdBy;
    @CurrentTimestamp
    @Column(name = "Created_Date")
    private Date createdDate;
}
