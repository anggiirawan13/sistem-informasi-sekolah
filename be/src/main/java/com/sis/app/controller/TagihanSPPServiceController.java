package com.sis.app.controller;

import com.sis.app.entitity.TagihanSPP;
import com.sis.app.impl.TagihanSPPServiceImpl;
import com.sis.app.service.TagihanSPPService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tagihan-spp")
public class TagihanSPPServiceController {

    @Autowired
    private TagihanSPPServiceImpl tagihanSPPServiceImpl;

    @GetMapping
    public BaseResponse getAllTagihanSPP() {
        return tagihanSPPServiceImpl.getAllTagihanSPP();
    }

    @GetMapping("/{id}")
    public BaseResponse getTagihanSPPById(@PathVariable("id") int id) {
        return tagihanSPPServiceImpl.getTagihanSPPById(id);
    }

    @PostMapping
    public BaseResponse saveTagihanSPP(TagihanSPP tagihanSPP) {
        return tagihanSPPServiceImpl.saveTagihanSPP(tagihanSPP);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTagihanSPP(@PathVariable("id") int id) {
        return tagihanSPPServiceImpl.deleteTagihanSPP(id);
    }
}
