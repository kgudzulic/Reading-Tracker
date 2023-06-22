package com.example.WebProjekat.controller;

import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.service.AutorService;
import com.example.WebProjekat.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("autori")
public class AutorRestController {
    @Autowired
    AutorService autorService;

    @Autowired
    KnjigaService knjigaService;


    @GetMapping("{id}/knjige")
    public ResponseEntity<List<Knjiga>> getKnjige(){

        return null;
    }
}
