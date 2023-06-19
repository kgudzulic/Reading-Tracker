package com.example.WebProjekat.controller;

import com.example.WebProjekat.dto.StavkaPoliceDTO;
import com.example.WebProjekat.model.*;
import com.example.WebProjekat.service.KnjigaService;
import com.example.WebProjekat.service.PolicaService;
import com.example.WebProjekat.service.RecenzijaService;
import com.example.WebProjekat.service.StavkaPoliceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("api/police")
public class PolicaRestController {
    @Autowired
    PolicaService policaService;

    @Autowired
    KnjigaService knjigaService;

    @Autowired
    RecenzijaService recenzijaService;

    @Autowired
    StavkaPoliceService stavkaPoliceService;

    @GetMapping("{id}")
    public ResponseEntity<Polica> getPolicaById(@PathVariable long id){
        Optional<Polica> optionalPolica = policaService.findById(id);
        if(optionalPolica.isPresent()){
            return ResponseEntity.ok(optionalPolica.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePolica(@PathVariable long id){
        Optional<Polica> optionalPolica = policaService.findById(id);
        if(optionalPolica.isPresent()){
            Polica polica = optionalPolica.get();
            if(!polica.getPrimarna()) {
                policaService.delete(polica);
                return ResponseEntity.ok().build();
            }
            else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    // pravljenje nove stavke
    @PostMapping("{id}/stavke-police")
    public ResponseEntity<?> addStavkaPolica(@PathVariable long id, @RequestBody StavkaPoliceDTO stavkaPoliceDTO, HttpSession httpSession){
        Optional<Polica> optionalPolica = policaService.findById(id);
        if(optionalPolica.isPresent()){
            Polica polica = optionalPolica.get();
            StavkaPolice stavkaPolice = new StavkaPolice();
            Optional<Knjiga> optionalKnjiga = knjigaService.findById(stavkaPoliceDTO.getKnjigaId());

            if(optionalKnjiga.isEmpty()){
                return ResponseEntity.badRequest().build();
            }

            if (!policaService.postojiKnjigaNaPrimarnojPolici((Korisnik)httpSession.getAttribute("korisnik"), optionalKnjiga.get())) {
                if(!polica.getPrimarna()){
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Mora se prvo staviti na primarnu policu");
                }
            }
            else{
                if(polica.getPrimarna()){
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Knjiga se već nalazi na primarnoj polici");
                }
            }

            if(polica.getNaziv().equals("Read")){
                if(stavkaPoliceDTO.getRecenzijaDTO() != null) {
                    Recenzija recenzija = new Recenzija();

                    recenzija.setTekst(stavkaPoliceDTO.getRecenzijaDTO().getTekst());
                    recenzija.setOcena(stavkaPoliceDTO.getRecenzijaDTO().getOcena());
                    recenzija.setDatumRecenzije(Date.valueOf(LocalDate.now()));

                    // TODO dodaj korisnika

                    Recenzija savucanaRecenzija = recenzijaService.save(recenzija);

                    stavkaPolice.setRecenzija(savucanaRecenzija);
                }
            }

            Knjiga knjiga= optionalKnjiga.get();
            stavkaPolice.setKnjiga(knjiga);
            polica.getStavkePolice().add(stavkaPolice);

            Polica savedPolica = policaService.save(polica);

            return ResponseEntity.ok(savedPolica);

        }
        return ResponseEntity.notFound().build();
    }

    // TODO ruta za brisanje stavke police sa police

    // dodavanje stavkePolice na odredjenu stavku

    @PostMapping("{policaId}/stavke-police/{stavkaPoliceId}")
    public ResponseEntity<?> postNewStavkaToPolica(@PathVariable long policaId, @PathVariable long stavkaPoliceId){
        Optional<Polica> optionalPolica =policaService.findById(policaId);
        if(optionalPolica.isPresent()){
            Optional<StavkaPolice> optionalStavkaPolice = stavkaPoliceService.findById(stavkaPoliceId);
            if(optionalStavkaPolice.isEmpty()){
                return ResponseEntity.badRequest().body("Stavka police sa tim id-em ne postoji");
            }
            Polica polica = optionalPolica.get();

            StavkaPolice stavkaPolice = optionalStavkaPolice.get();

            polica.getStavkePolice().add(stavkaPolice);

            Polica sacuvanaPolica = policaService.save(polica);

            return ResponseEntity.ok(sacuvanaPolica);
        }
        return ResponseEntity.notFound().build();
    }
}
