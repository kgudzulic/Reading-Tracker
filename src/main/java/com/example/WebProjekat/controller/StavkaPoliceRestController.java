package com.example.WebProjekat.controller;


import com.example.WebProjekat.dto.RecenzijaDTO;
import com.example.WebProjekat.dto.StavkaPoliceDTO;
import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Recenzija;
import com.example.WebProjekat.model.StavkaPolice;
import com.example.WebProjekat.service.KorisnikService;
import com.example.WebProjekat.service.RecenzijaService;
import com.example.WebProjekat.service.StavkaPoliceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("stavke-police")
public class StavkaPoliceRestController {
    @Autowired
    private StavkaPoliceService stavkaPoliceService;

    @Autowired
    private RecenzijaService recenzijaService;

    @Autowired
    private KorisnikService korisnikService;

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

    @PostMapping("{id}/recenzija")
    public ResponseEntity<Recenzija> postRecencija(@PathVariable long id, @RequestBody RecenzijaDTO recenzijaDTO, HttpSession session){
        Optional<StavkaPolice> optionalStavkaPolice = stavkaPoliceService.findById(id);
        if(optionalStavkaPolice.isPresent()) {
            Recenzija recenzija = new Recenzija();
            recenzija.setOcena(recenzijaDTO.getOcena());
            recenzija.setTekst(recenzijaDTO.getTekst());
            recenzija.setDatumRecenzije(Date.valueOf(LocalDate.now()));
            Optional<Korisnik> optionalKorisnik = korisnikService.findById(((Korisnik)session.getAttribute("korisnik")).getId()) ;

            recenzija.setKorisnik(optionalKorisnik.get());
            Recenzija sacuvanaRecenzija = recenzijaService.save(recenzija);

            StavkaPolice stavkaPolice = optionalStavkaPolice.get();

            stavkaPolice.setRecenzija(recenzija);

            stavkaPoliceService.save(stavkaPolice);

            return ResponseEntity.ok(sacuvanaRecenzija);
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
