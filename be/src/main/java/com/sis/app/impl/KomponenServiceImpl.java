package com.sis.app.impl;

import com.sis.app.entitity.Jurusan;
import com.sis.app.repo.JurusanRepo;
import com.sis.app.service.JurusanService;
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
public class JurusanServiceImpl implements JurusanService {

    @Autowired
    private JurusanRepo jurusanRepo;

    @Override
    public BaseResponse getAllKomponen(int page, int limit, String search) {
        List<Jurusan> jurusan = new ArrayList<>();
        HashMap<String, Object> addEntity = new HashMap<>();
        if (page < 0 || limit < 0) {
            jurusan = jurusanRepo.findAll();
        } else {
            Pageable pageable = Pageable.ofSize(limit).withPage(page);
            Page<Jurusan> komponenPage = jurusanRepo.findAll(pageable);
            jurusan = komponenPage.toList();

            addEntity.put("totalPage", komponenPage.getTotalPages());
            addEntity.put("totalData", komponenPage.getTotalElements());
            addEntity.put("numberOfData", komponenPage.getNumberOfElements());
            addEntity.put("number", komponenPage.getNumber());
        }

        return new BaseResponse(true, ResponseMessageConst.GET_SUCCESS.toString(), jurusan, addEntity);
    }

    @Override
    public BaseResponse getKomponenById(String id) {
        return new BaseResponse(true, ResponseMessageConst.GET_SUCCESS.toString(), jurusanRepo.findById(Integer.valueOf(id)).orElse(null));
    }

    @Override
    public BaseResponse saveKomponen(Jurusan jurusan) {
        return new BaseResponse(true, ResponseMessageConst.ADD_SUCCESS.toString(), jurusanRepo.save(jurusan));
    }

    @Override
    public BaseResponse updateKomponen(Jurusan jurusan) {
        return new BaseResponse(true, ResponseMessageConst.UPDATE_SUCCESS.toString(), jurusanRepo.save(jurusan));
    }

    @Override
    public BaseResponse deleteKomponen(String id) {
        jurusanRepo.deleteById(Integer.valueOf(id));
        return new BaseResponse(true, ResponseMessageConst.DELETE_SUCCESS.toString(), null);
    }
}
