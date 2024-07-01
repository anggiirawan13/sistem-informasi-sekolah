package com.sis.app.service;

import com.sis.app.entitity.TahunAjaran;
import com.sis.app.web.BaseResponse;

public interface TahunAjaranService {
    BaseResponse getAllTahunAjaran();
    BaseResponse getTahunAjaranById(int id);
    BaseResponse saveTahunAjaran(TahunAjaran tahunAjaran);
    BaseResponse deleteTahunAjaran(int id);
}

