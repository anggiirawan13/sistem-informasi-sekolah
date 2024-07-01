package com.sis.app.service;

import com.sis.app.entitity.Pembayaran;
import com.sis.app.web.BaseResponse;

public interface PembayaranService {
    BaseResponse getAllPembayaran();
    BaseResponse getPembayaranById(String id);
    BaseResponse savePembayaran(Pembayaran pembayaran);
    BaseResponse updatePembayaran(Pembayaran pembayaran);
    BaseResponse deletePembayaran(String id);
}
