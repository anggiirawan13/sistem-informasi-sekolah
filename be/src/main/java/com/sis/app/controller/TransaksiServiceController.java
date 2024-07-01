package com.sis.app.controller;

import com.sis.app.entitity.Transaksi;
import com.sis.app.impl.TransaksiServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/transaksi")
public class TransaksiServiceController {

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
    public BaseResponse saveTransaksi(@RequestBody Transaksi transaksi) {
        return transaksiServiceImpl.saveTransaksi(transaksi);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTransaksi(@PathVariable("id") int id) {
        return transaksiServiceImpl.deleteTransaksi(id);
    }
}
