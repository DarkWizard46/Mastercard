package com.mastercard.model.reference;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ref_edc_issue")
public class RefEdcIssue {
    @Id
    @Column(nullable = false)
    private Integer edcIssueId;
    private String edcissue;
}
