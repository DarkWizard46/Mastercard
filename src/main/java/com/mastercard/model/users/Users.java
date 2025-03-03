package com.mastercard.model.users;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String nik;

    @Column(name= "username", nullable = false, unique = true)
    private String username;
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    private String status;
    private String createdBy;
    @CreationTimestamp
    @Column(updatable = false, name = "created_date")
    private Date createdDate;
    private String tlCode;
    private String tlName;
    private String foto;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Privilege> privilege;
}
