package com.sis.app.controller;

import com.sis.app.entitity.Siswa;
import com.sis.app.impl.SiswaServiceImpl;
import com.sis.app.service.SiswaService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class SiswaServiceController implements SiswaService {

    @Autowired
    private SiswaServiceImpl siswaServiceImpl;

    @GetMapping
    public BaseResponse getAllSiswa() {
        return siswaServiceImpl.getAllSiswa();
    }

    @GetMapping("/{id}")
    public BaseResponse getSiswaById(@PathVariable("id") int id) {
        return siswaServiceImpl.getSiswaById(id);
    }

    @PostMapping
    public BaseResponse saveSiswa(Siswa siswa) {
        return siswaServiceImpl.saveSiswa(siswa);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteSiswa(@PathVariable("id") int id) {
        return siswaServiceImpl.deleteSiswa(id);
    }
}
