package com.example.WebProjekat.controller;


import com.example.WebProjekat.model.Zanr;
import com.example.WebProjekat.service.ZanrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/zanrovi")
public class ZanrRestController {
    @Autowired
    ZanrService zanrService;

    @GetMapping
    public ResponseEntity<List<Zanr>> get(){
        return ResponseEntity.ok(zanrService.findAll());
    }
}
