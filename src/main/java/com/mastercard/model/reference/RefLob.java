package com.mastercard.model.reference;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.data.annotation.Id;

import java.util.Date;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
