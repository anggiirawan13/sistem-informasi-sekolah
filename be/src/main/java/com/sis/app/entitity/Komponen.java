package com.sis.app.entitity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Komponen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String kodeKomponen;
    private String namaKomponen;

    @Column(name = "id_ta")
    private int idTa;
    private int biaya;
    private String kodeKelas;
    private Date tglDibuat;

    @ManyToOne
    @JoinColumn(name = "id_ta", insertable = false, updatable = false)
    private TahunAjaran tahunAjaran;

    @OneToMany(mappedBy = "komponen")
    private List<TagihanLain> tagihanLainList;
}
