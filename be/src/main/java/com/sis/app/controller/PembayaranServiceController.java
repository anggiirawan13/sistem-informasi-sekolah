package com.sis.app.controller;

import com.sis.app.entitity.Pembayaran;
import com.sis.app.impl.PembayaranServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/pembayaran")
public class PembayaranServiceController {

    @Autowired
    private PembayaranServiceImpl pembayaranServiceImpl;

    @GetMapping
    public BaseResponse getAllPembayaran() {
        return pembayaranServiceImpl.getAllPembayaran();
    }

    @GetMapping("/{id}")
    public BaseResponse getPembayaranById(@PathVariable("id") String id) {
        return pembayaranServiceImpl.getPembayaranById(id);
    }

    @PostMapping
    public BaseResponse savePembayaran(@RequestBody Pembayaran pembayaran) {
        return pembayaranServiceImpl.savePembayaran(pembayaran);
    }

    @PutMapping
    public BaseResponse updatePembayaran(@RequestBody Pembayaran pembayaran) {
        return pembayaranServiceImpl.updatePembayaran(pembayaran);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deletePembayaran(@PathVariable("id") String id) {
        return pembayaranServiceImpl.deletePembayaran(id);
    }
}
