package com.sis.app.service;

import com.sis.app.entitity.Kelas;
import com.sis.app.web.BaseResponse;

public interface KelasService {
    BaseResponse getAllPembayaran(int page, int limit, String search);
    BaseResponse getPembayaranById(String id);
    BaseResponse savePembayaran(Kelas kelas);
    BaseResponse updatePembayaran(Kelas kelas);
    BaseResponse deletePembayaran(String id);
}
