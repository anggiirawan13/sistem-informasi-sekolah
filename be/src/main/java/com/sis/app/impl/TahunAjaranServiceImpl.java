package com.sis.app.impl;

import com.sis.app.entitity.TahunAjaran;
import com.sis.app.repo.TahunAjaranRepo;
import com.sis.app.service.TahunAjaranService;
import com.sis.app.web.BaseResponse;
import com.sis.app.web.request.TahunAjaranReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public BaseResponse saveTahunAjaran(TahunAjaranReq req) {
        try {
            TahunAjaran tahunAjaran = new TahunAjaran();
            tahunAjaran.setPeriode(req.getPeriode());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date tglMulai = formatter.parse(req.getTglMulai());
            tahunAjaran.setTglMulai(tglMulai);

            Date tglAkhir = formatter.parse(req.getTglAkhir());
            tahunAjaran.setTglAkhir(tglAkhir);
            tahunAjaran.setKurikulum(req.getKurikulum());
            return new BaseResponse(true, "", tahunAjaranRepo.save(tahunAjaran));
        } catch (Exception e) {
            return new BaseResponse(false, "", null);
        }
    }

    @Override
    public BaseResponse deleteTahunAjaran(int id) {
        tahunAjaranRepo.deleteById(id);
        return new BaseResponse(true, "", null);
    }
}
