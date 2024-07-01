package com.sis.app.service;

import com.sis.app.web.BaseResponse;
import com.sis.app.web.request.TahunAjaranReq;

public interface TahunAjaranService {
    BaseResponse getAllTahunAjaran(int page, int limit, String search);
    BaseResponse getTahunAjaranById(int id);
    BaseResponse saveTahunAjaran(TahunAjaranReq req);
    BaseResponse deleteTahunAjaran(int id);
}

