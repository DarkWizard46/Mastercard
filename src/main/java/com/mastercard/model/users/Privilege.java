package com.mastercard.model.users;

import com.mastercard.constant.TableName;
import com.mastercard.constant.UserPrivileges;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TableName.PRIVILEGE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long privilege;

    @Column(name = "privilege_desc")
    @Enumerated(EnumType.STRING)
    private UserPrivileges privilege_desc;
}
