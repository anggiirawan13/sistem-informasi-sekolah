package com.sis.app.entitity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class TahunAjaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int periode;
    private Date tglMulai;
    private Date tglAkhir;
    private String kurikulum;

    @OneToMany(mappedBy = "tahunAjaran")
    private List<Siswa> siswa;

    @OneToMany(mappedBy = "tahunAjaran")
    private List<Komponen> komponen;

    @OneToMany(mappedBy = "tahunAjaran")
    private List<Transaksi> transaksi;

    @OneToMany(mappedBy = "tahunAjaran")
    private List<TagihanSPP> tagihanSPP;

    @OneToMany(mappedBy = "tahunAjaran")
    private List<TagihanLain> tagihanLain;
}
