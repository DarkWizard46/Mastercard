package com.mastercard.model.users;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_privilege")
public class UserPrivilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long privilege;

    @Column(nullable = false)
    private String privilegeDesc;
    @Column(nullable = false)
    private Integer role;
}
