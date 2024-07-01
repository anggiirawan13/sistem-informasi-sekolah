package com.sis.app.entitity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_ta")
    private int idTa;

    @Column(name = "id_siswa")
    private int idSiswa;
    private Date tglPembayaran;
    private int jumlahBayar;
    private int metodeBayar;

    @ManyToOne
    @JoinColumn(name = "id_ta", insertable = false, updatable = false)
    private TahunAjaran tahunAjaran;

    @ManyToOne
    @JoinColumn(name = "id_siswa", insertable = false, updatable = false)
    private Siswa siswa;

    @OneToMany(mappedBy = "pembayaran")
    private List<Transaksi> transaksiList;

}
