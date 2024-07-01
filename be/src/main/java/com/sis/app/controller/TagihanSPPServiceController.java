package com.sis.app.controller;

import com.sis.app.entitity.TagihanSPP;
import com.sis.app.impl.TagihanSPPServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
    public BaseResponse getTagihanSPPById(@PathVariable("id") String id) {
        return tagihanSPPServiceImpl.getTagihanSPPById(id);
    }

    @PostMapping
    public BaseResponse saveTagihanSPP(@RequestBody TagihanSPP tagihanSPP) {
        return tagihanSPPServiceImpl.saveTagihanSPP(tagihanSPP);
    }

    @PutMapping
    public BaseResponse updateTagihanSPP(@RequestBody TagihanSPP tagihanSPP) {
        return tagihanSPPServiceImpl.updateTagihanSPP(tagihanSPP);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTagihanSPP(@PathVariable("id") String id) {
        return tagihanSPPServiceImpl.deleteTagihanSPP(id);
    }
}
