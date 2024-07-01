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
    public BaseResponse getSiswaById(String id) {
        return new BaseResponse(true, "", siswaRepo.findById(Integer.valueOf(id)).orElse(null));
    }

    @Override
    public BaseResponse saveSiswa(Siswa siswa) {
        return new BaseResponse(true, "", siswaRepo.save(siswa));
    }

    public BaseResponse updateSiswa(Siswa siswa) {
        return new BaseResponse(true, "", siswaRepo.save(siswa));
    }

    @Override
    public BaseResponse deleteSiswa(String id) {
        siswaRepo.deleteById(Integer.valueOf(id));
        return new BaseResponse(true, "", null);
    }
}
