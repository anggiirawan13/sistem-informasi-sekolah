package com.sis.app.impl;

import com.sis.app.entitity.TagihanSPP;
import com.sis.app.repo.TagihanSPPRepo;
import com.sis.app.service.TagihanSPPService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagihanSPPServiceImpl implements TagihanSPPService {

    @Autowired
    private TagihanSPPRepo tagihanSPPRepo;

    @Override
    public BaseResponse getAllTagihanSPP() {
        return new BaseResponse(true, "", tagihanSPPRepo.findAll());
    }

    @Override
    public BaseResponse getTagihanSPPById(int id) {
        return new BaseResponse(true, "", tagihanSPPRepo.findById(id).orElse(null));
    }

    @Override
    public BaseResponse saveTagihanSPP(TagihanSPP tagihanSPP) {
        return new BaseResponse(true, "", tagihanSPPRepo.save(tagihanSPP));
    }

    @Override
    public BaseResponse deleteTagihanSPP(int id) {
        tagihanSPPRepo.deleteById(id);
        return new BaseResponse(true, "", null);
    }
}
