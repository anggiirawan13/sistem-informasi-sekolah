package com.sis.app.controller;

import com.sis.app.entitity.Transaksi;
import com.sis.app.impl.TransaksiServiceImpl;
import com.sis.app.service.TransaksiService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class TransaksiServiceController implements TransaksiService {

    @Autowired
    private TransaksiServiceImpl transaksiServiceImpl;

    @GetMapping
    public BaseResponse getAllTransaksi() {
        return transaksiServiceImpl.getAllTransaksi();
    }

    @GetMapping("/{id}")
    public BaseResponse getTransaksiById(@PathVariable("id") int id) {
        return transaksiServiceImpl.getTransaksiById(id);
    }

    @PostMapping
    public BaseResponse saveTransaksi(Transaksi transaksi) {
        return transaksiServiceImpl.saveTransaksi(transaksi);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTransaksi(@PathVariable("id") int id) {
        return transaksiServiceImpl.deleteTransaksi(id);
    }
}
