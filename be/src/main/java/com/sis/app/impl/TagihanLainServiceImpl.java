package com.sis.app.impl;

import com.sis.app.entitity.TagihanLain;
import com.sis.app.repo.TagihanLainRepo;
import com.sis.app.service.TagihanLainService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagihanLainServiceImpl implements TagihanLainService {

    @Autowired
    private TagihanLainRepo tagihanLainRepo;

    @Override
    public BaseResponse getAllTagihanLain() {
        return new BaseResponse(true, "", tagihanLainRepo.findAll());
    }

    @Override
    public BaseResponse getTagihanLainById(String id) {
        return new BaseResponse(true, "", tagihanLainRepo.findById(Integer.valueOf(id)).orElse(null));
    }

    @Override
    public BaseResponse saveTagihanLain(TagihanLain tagihanLain) {
        return new BaseResponse(true, "", tagihanLainRepo.save(tagihanLain));
    }

    @Override
    public BaseResponse deleteTagihanLain(String id) {
        tagihanLainRepo.deleteById(Integer.valueOf(id));
        return new BaseResponse(true, "", null);
    }
}
