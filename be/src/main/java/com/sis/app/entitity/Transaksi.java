package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(name = "kode_transaksi")
    @JsonProperty("kode_transaksi")
    private String kodeTransaksi;

    @Column(name = "id_ta")
    @JsonProperty("id_ta")
    private int idTa;

    @Column(name = "id_siswa")
    @JsonProperty("id_siswa")
    private int idSiswa;

    @Column(name = "id_pembayaran")
    @JsonProperty("id_pembayaran")
    private int idPembayaran;

    @Column(name = "tgl_pembayaran")
    @JsonProperty("tgl_pembayaran")
    private Date tglPembayaran;

    @Column(name = "status")
    @JsonProperty("status")
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
