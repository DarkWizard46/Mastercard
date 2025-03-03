package com.mastercard.model.reference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ref_hit_code")
public class RefHitCode {
    @Id
    @Column(nullable = false)
    private Integer hitCode;
    private String description;
}
