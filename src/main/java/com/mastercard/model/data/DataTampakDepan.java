package com.mastercard.model.data;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "data_tampak_depan")
public class DataTampakDepan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String merchantId;
    @Column(nullable = false)
    private String koordinatFoto;
    @Column(nullable = false)
    private String kodePosMall;
    @Column(nullable = false)
    private String kodePosKoordinatFoto;
    @Column(nullable = false)
    private String keterangan;
    private String statusPemasangan;
}
