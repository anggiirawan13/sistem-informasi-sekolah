package com.sis.app.impl;

import com.sis.app.entitity.TahunAjaran;
import com.sis.app.entitity.TahunAjaran;
import com.sis.app.repo.TahunAjaranRepo;
import com.sis.app.service.TahunAjaranService;
import com.sis.app.web.BaseResponse;
import com.sis.app.web.request.TahunAjaranReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class TahunAjaranServiceImpl implements TahunAjaranService {

    @Autowired
    private TahunAjaranRepo tahunAjaranRepo;

    @Override
    public BaseResponse getAllTahunAjaran(int page, int limit, String search) {
        List<TahunAjaran> tahunAjaran = new ArrayList<>();
        HashMap<String, Object> addEntity = new HashMap<>();
        if (page < 0 || limit < 0) {
            tahunAjaran = tahunAjaranRepo.findAll();
        } else {
            Pageable pageable = Pageable.ofSize(limit).withPage(page);
            Page<TahunAjaran> tahunAjaranPage = tahunAjaranRepo.findAll(pageable);
            tahunAjaran = tahunAjaranPage.toList();

            addEntity.put("totalPage", tahunAjaranPage.getTotalPages());
            addEntity.put("totalData", tahunAjaranPage.getTotalElements());
            addEntity.put("numberOfData", tahunAjaranPage.getNumberOfElements());
            addEntity.put("number", tahunAjaranPage.getNumber());
        }

        return new BaseResponse(true, "", tahunAjaran, addEntity);
    }

    @Override
    public BaseResponse getTahunAjaranById(int id) {
        return new BaseResponse(true, "", tahunAjaranRepo.findById(id).orElse(null));
    }

    @Override
    public BaseResponse saveTahunAjaran(TahunAjaran req) {
        try {
            return new BaseResponse(true, "", tahunAjaranRepo.save(req));
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
