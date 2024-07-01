package com.sis.app.controller;

import com.sis.app.entitity.Siswa;
import com.sis.app.impl.SiswaServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/siswa")
public class SiswaServiceController {

    @Autowired
    private SiswaServiceImpl siswaServiceImpl;

    @GetMapping
    public BaseResponse getAllSiswa() {
        return siswaServiceImpl.getAllSiswa();
    }

    @GetMapping("/{id}")
    public BaseResponse getSiswaById(@PathVariable("id") String id) {
        return siswaServiceImpl.getSiswaById(id);
    }

    @PostMapping
    public BaseResponse saveSiswa(@RequestBody Siswa siswa) {
        return siswaServiceImpl.saveSiswa(siswa);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteSiswa(@PathVariable("id") String id) {
        return siswaServiceImpl.deleteSiswa(id);
    }
}
