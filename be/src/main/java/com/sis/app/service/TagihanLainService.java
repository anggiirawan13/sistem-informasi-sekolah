package com.sis.app.service;

import com.sis.app.entitity.TagihanLain;
import com.sis.app.web.BaseResponse;

public interface TagihanLainService {
    BaseResponse getAllTagihanLain();
    BaseResponse getTagihanLainById(int id);
    BaseResponse saveTagihanLain(TagihanLain tagihanLain);
    BaseResponse deleteTagihanLain(int id);
}
