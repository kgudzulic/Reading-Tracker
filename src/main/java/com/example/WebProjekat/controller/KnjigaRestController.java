package com.example.WebProjekat.controller;

import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.model.Recenzija;
import com.example.WebProjekat.model.StavkaPolice;
import com.example.WebProjekat.service.KnjigaService;
import com.example.WebProjekat.service.RecenzijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/knjige")
public class KnjigaRestController {
    @Autowired
    KnjigaService knjigaService;

    @Autowired
    RecenzijaService recenzijaService;

    @GetMapping
    public ResponseEntity<List<Knjiga>> get(@RequestParam(required = false) String naslov){

        return ResponseEntity.ok(knjigaService.findByNaslovIgnoreCaseContaining(naslov));
    }

    @GetMapping("{id}")
    public ResponseEntity<Knjiga> getBookById(@PathVariable long id){
        Optional<Knjiga> knjigaOptional = knjigaService.findById(id);
        if(knjigaOptional.isPresent()){
            return ResponseEntity.ok(knjigaOptional.get());

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}/recenzije")
    public ResponseEntity<List<Recenzija>> get(@PathVariable long id){

        Optional<Knjiga> optionalKnjiga = knjigaService.findById(id);
        if(optionalKnjiga.isPresent()){
            Knjiga knjiga = optionalKnjiga.get();
            return ResponseEntity.ok(recenzijaService.findAllRecenzijaByKnjiga(knjiga));
        }
        return ResponseEntity.notFound().build();
    }
}
