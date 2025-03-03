package com.mastercard.model.users;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    private String nik;
    private String username;
    private String name;
    private String password;
    private Integer privilege;
    private String status;
    private String createdBy;
    @CreationTimestamp
    @Column(updatable = false, name = "created_date")
    private Date createdDate;
    private String tlCode;
    private String tlName;
    private String foto;
}
