package com.sis.app.impl;

import com.sis.app.entitity.Komponen;
import com.sis.app.repo.KomponenRepo;
import com.sis.app.service.KomponenService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KomponenServiceImpl implements KomponenService {

    @Autowired
    private KomponenRepo komponenRepo;

    @Override
    public BaseResponse getAllKomponen() {
        return new BaseResponse(true, "", komponenRepo.findAll());
    }

    @Override
    public BaseResponse getKomponenById(int id) {
        return new BaseResponse(true, "", komponenRepo.findById(id).orElse(null));
    }

    @Override
    public BaseResponse saveKomponen(Komponen komponen) {
        return new BaseResponse(true, "", komponenRepo.save(komponen));
    }

    @Override
    public BaseResponse deleteKomponen(int id) {
        komponenRepo.deleteById(id);
        return new BaseResponse(true, "", null);
    }
}
