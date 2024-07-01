package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_ta")
    @JsonProperty("id_ta")
    private int idTa;

    @Column(name = "nisn")
    @JsonProperty("nisn")
    private int nisn;

    @Column(name = "nama_lengkap")
    @JsonProperty("nama_lengkap")
    private String namaLengkap;

    @Column(name = "tanggal_lahir")
    @JsonProperty("tanggal_lahir")
    private Date tanggalLahir;

    @Column(name = "alamat")
    @JsonProperty("alamat")
    private String alamat;

    @Column(name = "nama_ortu")
    @JsonProperty("nama_ortu")
    private String namaOrtu;

    @Column(name = "telp")
    @JsonProperty("telp")
    private String telp;

    @Column(name = "foto")
    @JsonProperty("foto")
    private String foto;

    @Column(name = "status")
    @JsonProperty("status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_ta", insertable = false, updatable = false)
    private TahunAjaran tahunAjaran;

    @OneToMany(mappedBy = "siswa")
    private List<Transaksi> transaksiList;
}
