package com.sis.app.impl;

import com.sis.app.entitity.Siswa;
import com.sis.app.repo.SiswaRepo;
import com.sis.app.service.SiswaService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiswaServiceImpl implements SiswaService {

    @Autowired
    private SiswaRepo siswaRepo;

    @Override
    public BaseResponse getAllSiswa() {
        return new BaseResponse(true, "", siswaRepo.findAll());
    }

    @Override
    public BaseResponse getSiswaById(int id) {
        return new BaseResponse(true, "", siswaRepo.findById(id).orElse(null));
    }

    @Override
    public BaseResponse saveSiswa(Siswa siswa) {
        return new BaseResponse(true, "", siswaRepo.save(siswa));
    }

    @Override
    public BaseResponse deleteSiswa(int id) {
        siswaRepo.deleteById(id);
        return new BaseResponse(true, "", null);
    }
}
