package com.sis.app.controller;

import com.sis.app.entitity.TahunAjaran;
import com.sis.app.impl.TahunAjaranServiceImpl;
import com.sis.app.web.BaseResponse;
import com.sis.app.web.request.TahunAjaranReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tahun-ajaran")
public class TahunAjaranServiceController {

    @Autowired
    private TahunAjaranServiceImpl tahunAjaranServiceImpl;

    @GetMapping
    public BaseResponse getAllTahunAjaran(@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "limit", required = false, defaultValue = "0") int limit, @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        return tahunAjaranServiceImpl.getAllTahunAjaran(page, limit, search);
    }

    @GetMapping("/{id}")
    public BaseResponse getTahunAjaranById(@PathVariable("id") int id) {
        return tahunAjaranServiceImpl.getTahunAjaranById(id);
    }

    @PostMapping
    public BaseResponse saveTahunAjaran(@RequestBody TahunAjaran req) {
        return tahunAjaranServiceImpl.saveTahunAjaran(req);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTahunAjaran(@PathVariable("id") int id) {
        return tahunAjaranServiceImpl.deleteTahunAjaran(id);
    }
}
