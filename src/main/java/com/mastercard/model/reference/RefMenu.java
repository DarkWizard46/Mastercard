package com.mastercard.model.reference;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.data.annotation.Id;

import java.util.Date;

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

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
