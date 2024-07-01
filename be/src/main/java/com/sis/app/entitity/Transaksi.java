package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
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
    private LocalDate tglPembayaran;

    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    @OneToMany(mappedBy = "transaksi")
    private List<TagihanSPP> tagihanSPP;

    @OneToMany(mappedBy = "transaksi")
    private List<TagihanLain> tagihanLain;
}
