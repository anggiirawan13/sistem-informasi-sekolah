package com.sis.app.impl;

import com.sis.app.entitity.Pembayaran;
import com.sis.app.repo.PembayaranRepo;
import com.sis.app.service.PembayaranService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PembayaranServiceImpl implements PembayaranService {

    @Autowired
    private PembayaranRepo pembayaranRepo;

    @Override
    public BaseResponse getAllPembayaran() {
        return new BaseResponse(true, "", pembayaranRepo.findAll());
    }

    @Override
    public BaseResponse getPembayaranById(String id) {
        return new BaseResponse(true, "", pembayaranRepo.findById(Integer.valueOf(id)).orElse(null));
    }

    @Override
    public BaseResponse savePembayaran(Pembayaran pembayaran) {
        return new BaseResponse(true, "", pembayaranRepo.save(pembayaran));
    }

    @Override
    public BaseResponse deletePembayaran(String id) {
        pembayaranRepo.deleteById(Integer.valueOf(id));
        return new BaseResponse(true, "", null);
    }
}
