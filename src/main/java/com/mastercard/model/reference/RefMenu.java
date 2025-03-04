package com.mastercard.model.reference;

import jakarta.persistence.*;
import lombok.*;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long menuId;

    private String menu;
    @CurrentTimestamp
    @Column(name = "created_date")
    private Date createdDate;
    private String createdBy;
}
