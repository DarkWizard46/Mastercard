package com.mastercard.model.users;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
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

    @Column(name = "is_enable", nullable = false)
    private boolean isEnable = true; // Default: aktif

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_privileges",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege")
    )
    private List<Privilege> privilege;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return privilege.stream()
                .map(priv -> new SimpleGrantedAuthority("PRIV_" + priv.getPrivilegeDesc())) // Hapus .name()
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }
}
