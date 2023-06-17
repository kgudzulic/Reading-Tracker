package com.example.WebProjekat.controller;


import com.example.WebProjekat.dto.StavkaPoliceDTO;
import com.example.WebProjekat.model.StavkaPolice;
import com.example.WebProjekat.service.StavkaPoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("stavke-police")
public class StavkaPoliceRestController {
    @Autowired
    private StavkaPoliceService stavkaPoliceService;

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        Optional<StavkaPolice> optionalStavkaPolice = stavkaPoliceService.findById(id);
        if(optionalStavkaPolice.isPresent()){
            StavkaPolice stavkaPolice = optionalStavkaPolice.get();

            stavkaPoliceService.delete(stavkaPolice);
            return ResponseEntity.ok("Uspešno obrisana stavka police");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody StavkaPoliceDTO stavkaPoliceDTO){
        Optional<StavkaPolice> optionalStavkaPolice = stavkaPoliceService.findById(id);
        if(optionalStavkaPolice.isPresent()){
            StavkaPolice stavkaPolice = optionalStavkaPolice.get();
            if(stavkaPoliceDTO.getRecenzijaDTO() != null) {
                // provera ako je DTO
                //
            }
            stavkaPoliceService.delete(stavkaPolice);
            return ResponseEntity.ok("Uspešno obrisana stavka police");
        }
        return ResponseEntity.notFound().build();
    }
}
