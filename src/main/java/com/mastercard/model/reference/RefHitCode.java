package com.mastercard.model.reference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ref_hit_code")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefHitCode {
    @Id
    @Column(nullable = false)
    private Integer hitCode;
    private String description;

    public Integer getHitCode() {
        return hitCode;
    }

    public void setHitCode(Integer hitCode) {
        this.hitCode = hitCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
