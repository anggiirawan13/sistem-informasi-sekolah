package com.sis.app.controller;

import com.sis.app.entitity.TagihanLain;
import com.sis.app.impl.TagihanLainServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tagihan-lain")
public class TagihanLainServiceController {

    @Autowired
    private TagihanLainServiceImpl tagihanLainServiceImpl;

    @GetMapping
    public BaseResponse getAllTagihanLain() {
        return tagihanLainServiceImpl.getAllTagihanLain();
    }

    @GetMapping("/{id}")
    public BaseResponse getTagihanLainById(@PathVariable("id") String id) {
        return tagihanLainServiceImpl.getTagihanLainById(id);
    }

    @PostMapping
    public BaseResponse saveTagihanLain(@RequestBody TagihanLain tagihanLain) {
        return tagihanLainServiceImpl.saveTagihanLain(tagihanLain);
    }

    @PostMapping
    public BaseResponse updateTagihanLain(@RequestBody TagihanLain tagihanLain) {
        return tagihanLainServiceImpl.updateTagihanLain(tagihanLain);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTagihanLain(@PathVariable("id") String id) {
        return tagihanLainServiceImpl.deleteTagihanLain(id);
    }
}
