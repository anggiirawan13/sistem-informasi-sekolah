package com.sis.app.entitity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class TagihanLain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_komponen")
    private int idKomponen;

    @Column(name = "id_transaksi")
    private int idTransaksi;

    @Column(name = "id_ta")
    private int idTa;

    @Column(name = "id_siswa")
    private int idSiswa;

    private Date tglBayar;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_komponen", insertable = false, updatable = false)
    private Komponen komponen;

    @ManyToOne
    @JoinColumn(name = "id_transaksi", insertable = false, updatable = false)
    private Transaksi transaksi;

    @ManyToOne
    @JoinColumn(name = "id_ta", insertable = false, updatable = false)
    private TahunAjaran tahunAjaran;

    @ManyToOne
    @JoinColumn(name = "id_siswa", insertable = false, updatable = false)
    private Siswa siswa;
}
