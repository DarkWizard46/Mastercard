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
@Table(name = "ref_menu")
public class RefMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer menuId;
    private String menu;
    @CurrentTimestamp
    @Column(name = "created_date")
    private Date createdDate;
    private String createdBy;
}
