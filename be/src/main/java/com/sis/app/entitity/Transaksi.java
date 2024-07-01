package com.sis.app.entitity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String kodeTransaksi;

    @Column(name = "id_ta")
    private int idTa;

    @Column(name = "id_siswa")
    private int idSiswa;

    @Column(name = "id_pembayaran")
    private int idPembayaran;

    private Date tglPembayaran;

    private String status;

    @ManyToOne
    @JoinColumn(name = "id_ta", insertable = false, updatable = false)
    private TahunAjaran tahunAjaran;

    @ManyToOne
    @JoinColumn(name = "id_siswa", insertable = false, updatable = false)
    private Siswa siswa;

    @ManyToOne
    @JoinColumn(name = "id_pembayaran", insertable = false, updatable = false)
    private Pembayaran pembayaran;

    @OneToMany(mappedBy = "transaksi")
    private List<TagihanSPP> tagihanSPP;

    @OneToMany(mappedBy = "transaksi")
    private List<TagihanLain> tagihanLain;
}
