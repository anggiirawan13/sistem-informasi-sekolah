package com.sis.app.service;

import com.sis.app.entitity.Siswa;
import com.sis.app.web.BaseResponse;

public interface SiswaService {
    BaseResponse getAllSiswa();
    BaseResponse getSiswaById(String id);
    BaseResponse saveSiswa(Siswa siswa);
    BaseResponse updateSiswa(Siswa siswa);
    BaseResponse deleteSiswa(String id);
}
