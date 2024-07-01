package com.sis.app.impl;

import com.sis.app.entitity.TahunAjaran;
import com.sis.app.repo.TahunAjaranRepo;
import com.sis.app.service.TahunAjaranService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TahunAjaranServiceImpl implements TahunAjaranService {

    @Autowired
    private TahunAjaranRepo tahunAjaranRepo;

    @Override
    public BaseResponse getAllTahunAjaran() {
        return new BaseResponse(true, "", tahunAjaranRepo.findAll());
    }

    @Override
    public BaseResponse getTahunAjaranById(int id) {
        return new BaseResponse(true, "", tahunAjaranRepo.findById(id).orElse(null));
    }

    @Override
    public BaseResponse saveTahunAjaran(TahunAjaran tahunAjaran) {
        return new BaseResponse(true, "", tahunAjaranRepo.save(tahunAjaran));
    }

    @Override
    public BaseResponse deleteTahunAjaran(int id) {
        tahunAjaranRepo.deleteById(id);
        return new BaseResponse(true, "", null);
    }
}
