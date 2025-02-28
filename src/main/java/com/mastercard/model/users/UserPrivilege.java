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
    @Column(nullable = false)
    private Integer privilege;
    @Column(nullable = false)
    private String privilegeDesc;
    @Column(nullable = false)
    private Integer role;
}
