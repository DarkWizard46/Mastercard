package com.mastercard.model.reference;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ref_lob")
public class RefLob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String lob;
    private String createdBy;
    @CurrentTimestamp
    @Column(name = "Created_Date")
    private Date createdDate;
}
