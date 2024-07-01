package com.sis.app.service;

import com.sis.app.entitity.Komponen;
import com.sis.app.web.BaseResponse;

public interface KomponenService {
    BaseResponse getAllKomponen();
    BaseResponse getKomponenById(int id);
    BaseResponse saveKomponen(Komponen komponen);
    BaseResponse deleteKomponen(int id);
}
