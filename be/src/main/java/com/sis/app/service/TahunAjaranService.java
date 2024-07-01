package com.sis.app.service;

import com.sis.app.web.request.TahunAjaranReq;
import com.sis.app.web.BaseResponse;

public interface TahunAjaranService {
    BaseResponse getAllTahunAjaran();
    BaseResponse getTahunAjaranById(int id);
    BaseResponse saveTahunAjaran(TahunAjaranReq req);
    BaseResponse deleteTahunAjaran(int id);
}

