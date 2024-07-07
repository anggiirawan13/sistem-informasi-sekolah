package com.sis.app.controller;

import com.sis.app.entitity.Kelas;
import com.sis.app.impl.KelasServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/pembayaran")
public class KelasController {

    @Autowired
    private KelasServiceImpl kelasServiceImpl;

    @GetMapping
    public BaseResponse getAllPembayaran(@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "limit", required = false, defaultValue = "10") int limit, @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        return kelasServiceImpl.getAllPembayaran(page, limit, search);
    }

    @GetMapping("/{id}")
    public BaseResponse getPembayaranById(@PathVariable("id") String id) {
        return kelasServiceImpl.getPembayaranById(id);
    }

    @PostMapping
    public BaseResponse savePembayaran(@RequestBody Kelas kelas) {
        return kelasServiceImpl.savePembayaran(kelas);
    }

    @PutMapping
    public BaseResponse updatePembayaran(@RequestBody Kelas kelas) {
        return kelasServiceImpl.updatePembayaran(kelas);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deletePembayaran(@PathVariable("id") String id) {
        return kelasServiceImpl.deletePembayaran(id);
    }
}
