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
@Table(name = "ref_conclusion")
public class RefConclusion {
    @Id
    @Column(nullable = false)
    private Integer conclusionId;
    private String edcTest;
    private String edcIssue;
    private String conclusion;
}
