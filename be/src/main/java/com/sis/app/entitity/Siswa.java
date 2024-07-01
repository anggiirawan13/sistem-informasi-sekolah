package com.sis.app.entitity;

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
    private int idTa;
    private int nisn;
    private String namaLengkap;
    private Date tanggalLahir;
    private String alamat;
    private String namaOrtu;
    private String telp;
    private String foto;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_ta", insertable = false, updatable = false)
    private TahunAjaran tahunAjaran;

    @OneToMany(mappedBy = "siswa")
    private List<Transaksi> transaksiList;
}
