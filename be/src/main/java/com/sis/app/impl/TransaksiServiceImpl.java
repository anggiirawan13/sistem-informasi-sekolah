package com.sis.app.impl;

import com.sis.app.entitity.Transaksi;
import com.sis.app.repo.TransaksiRepo;
import com.sis.app.service.TransaksiService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaksiServiceImpl implements TransaksiService {

    @Autowired
    private TransaksiRepo transaksiRepo;

    @Override
    public BaseResponse getAllTransaksi() {
        return new BaseResponse(true, "", transaksiRepo.findAll());
    }

    @Override
    public BaseResponse getTransaksiById(int id) {
        return new BaseResponse(true, "", transaksiRepo.findById(id).orElse(null));
    }

    @Override
    public BaseResponse saveTransaksi(Transaksi transaksi) {
        return new BaseResponse(true, "", transaksiRepo.save(transaksi));
    }

    @Override
    public BaseResponse deleteTransaksi(int id) {
        transaksiRepo.deleteById(id);
        return new BaseResponse(true, "", null);
    }
}
