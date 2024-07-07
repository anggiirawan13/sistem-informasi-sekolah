package com.sis.app.service;

import com.sis.app.entitity.Jurusan;
import com.sis.app.web.BaseResponse;

public interface JurusanService {
    BaseResponse getAllKomponen(int page, int limit, String search);
    BaseResponse getKomponenById(String id);
    BaseResponse saveKomponen(Jurusan jurusan);
    BaseResponse updateKomponen(Jurusan jurusan);
    BaseResponse deleteKomponen(String id);
}
