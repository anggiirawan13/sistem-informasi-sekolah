package com.sis.app.impl;

import com.sis.app.entitity.Kelas;
import com.sis.app.repo.KelasRepo;
import com.sis.app.service.KelasService;
import com.sis.app.web.BaseResponse;
import com.sis.constanta.ResponseMessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class KelasServiceImpl implements KelasService {

    @Autowired
    private KelasRepo kelasRepo;

    @Override
    public BaseResponse getAllPembayaran(int page, int limit, String search) {
        List<Kelas> kelas = new ArrayList<>();
        HashMap<String, Object> addEntity = new HashMap<>();
        if (page < 0 || limit < 0) {
            kelas = kelasRepo.findAll();
        } else {
            Pageable pageable = Pageable.ofSize(limit).withPage(page);
            Page<Kelas> pembayaranPage = kelasRepo.findAll(pageable);
            kelas = pembayaranPage.toList();

            addEntity.put("totalPage", pembayaranPage.getTotalPages());
            addEntity.put("totalData", pembayaranPage.getTotalElements());
            addEntity.put("numberOfData", pembayaranPage.getNumberOfElements());
            addEntity.put("number", pembayaranPage.getNumber());
        }

        return new BaseResponse(true, ResponseMessageConst.GET_SUCCESS.toString(), kelas, addEntity);
    }

    @Override
    public BaseResponse getPembayaranById(String id) {
        return new BaseResponse(true, ResponseMessageConst.GET_SUCCESS.toString(), kelasRepo.findById(Integer.valueOf(id)).orElse(null));
    }

    @Override
    public BaseResponse savePembayaran(Kelas kelas) {
        return new BaseResponse(true, ResponseMessageConst.ADD_SUCCESS.toString(), kelasRepo.save(kelas));
    }

    @Override
    public BaseResponse updatePembayaran(Kelas kelas) {
        return new BaseResponse(true, ResponseMessageConst.UPDATE_SUCCESS.toString(), kelasRepo.save(kelas));
    }

    @Override
    public BaseResponse deletePembayaran(String id) {
        kelasRepo.deleteById(Integer.valueOf(id));
        return new BaseResponse(true, ResponseMessageConst.DELETE_SUCCESS.toString(), null);
    }
}
