package com.sis.app.service;

import com.sis.app.entitity.TagihanSPP;
import com.sis.app.web.BaseResponse;

public interface TagihanSPPService {
    BaseResponse getAllTagihanSPP();
    BaseResponse getTagihanSPPById(int id);
    BaseResponse saveTagihanSPP(TagihanSPP tagihanSPP);
    BaseResponse deleteTagihanSPP(int id);
}
