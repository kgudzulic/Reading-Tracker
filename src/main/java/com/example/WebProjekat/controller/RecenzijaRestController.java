package com.example.WebProjekat.controller;

import com.example.WebProjekat.dto.RecenzijaDTO;
import com.example.WebProjekat.model.Recenzija;
import com.example.WebProjekat.service.RecenzijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/recenzije")
public class RecenzijaRestController {
    @Autowired
    RecenzijaService recenzijaService;

    @GetMapping
    public ResponseEntity<List<Recenzija>> get(){
        return ResponseEntity.ok(recenzijaService.findAll());
    }

    @PutMapping("{id}")
    public  ResponseEntity<Recenzija> updateRecenzija(@PathVariable long id, @RequestBody RecenzijaDTO recenzijaDTO){
        Optional<Recenzija> recenzijaOptional = recenzijaService.findById(id);
        if(recenzijaOptional.isPresent()){
            Recenzija recenzija = recenzijaOptional.get();

            recenzija.setTekst(recenzijaDTO.getTekst());
            recenzija.setOcena(recenzija.getOcena());

            recenzijaService.save(recenzija);

            return ResponseEntity.ok(recenzija);
        }
        return ResponseEntity.notFound().build();
    }
}
