package com.sis.app.service;

import com.sis.app.entitity.Pembayaran;
import com.sis.app.web.BaseResponse;

public interface PembayaranService {
    BaseResponse getAllPembayaran();
    BaseResponse getPembayaranById(int id);
    BaseResponse savePembayaran(Pembayaran pembayaran);
    BaseResponse deletePembayaran(int id);
}
