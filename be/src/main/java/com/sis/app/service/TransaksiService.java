package com.sis.app.service;

import com.sis.app.entitity.Transaksi;
import com.sis.app.web.BaseResponse;

public interface TransaksiService {
    BaseResponse getAllTransaksi(int page, int limit, String search);
    BaseResponse getTransaksiById(int id);
    BaseResponse saveTransaksi(Transaksi transaksi);
    BaseResponse deleteTransaksi(int id);
}
