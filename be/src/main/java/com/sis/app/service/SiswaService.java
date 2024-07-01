package com.sis.app.service;

import com.sis.app.entitity.Siswa;
import com.sis.app.web.BaseResponse;

public interface SiswaService {
    BaseResponse getAllSiswa();
    BaseResponse getSiswaById(int id);
    BaseResponse saveSiswa(Siswa siswa);
    BaseResponse deleteSiswa(int id);
}
