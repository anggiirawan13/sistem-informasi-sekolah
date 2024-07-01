package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Komponen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "kode_komponen")
    @JsonProperty("kode_komponen")
    private String kodeKomponen;

    @Column(name = "nama_komponen")
    @JsonProperty("nama_komponen")
    private String namaKomponen;

    @Column(name = "id_ta")
    @JsonProperty("id_ta")
    private int idTa;

    @Column(name = "biaya")
    @JsonProperty("biaya")
    private int biaya;

    @Column(name = "kode_kelas")
    @JsonProperty("kode_kelas")
    private String kodeKelas;

    @Column(name = "tgl_dibuat")
    @JsonProperty("tgl_dibuat")
    private LocalDate tglDibuat;

    @OneToMany(mappedBy = "komponen")
    private List<TagihanLain> tagihanLainList;
}
