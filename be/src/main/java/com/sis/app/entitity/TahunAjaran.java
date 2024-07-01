package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(name = "periode")
    @JsonProperty("periode")
    private int periode;

    @Column(name = "tgl_mulai")
    @JsonProperty("tgl_mulai")
    private Date tglMulai;

    @Column(name = "tgl_akhir")
    @JsonProperty("tgl_akhir")
    private Date tglAkhir;

    @Column(name = "kurikulum")
    @JsonProperty("kurikulum")
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
