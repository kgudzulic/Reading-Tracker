package com.example.WebProjekat.controller;

import com.example.WebProjekat.dto.*;
import com.example.WebProjekat.model.*;
import com.example.WebProjekat.service.CitalacService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitalacRestController {

    @Autowired
    private CitalacService citalacService;

    @PostMapping("/api/citalac/dodaj_policu")
    public ResponseEntity<Polica> novaPolica(@RequestBody PolicaDTO policaDTO, HttpSession session){
        KorisnikDTO ulogovaniKorisnik = (KorisnikDTO) session.getAttribute("CITALAC");

        if(ulogovaniKorisnik == null){
            return new ResponseEntity("Citalac nije ulogovan.", HttpStatus.BAD_REQUEST);
        }
        if(ulogovaniKorisnik.getUloga().getNaziv() != citalacService.getUlogaByNaziv("CITALAC")){
            return new ResponseEntity("Dodavanje police nije moguce, neispravna uloga.", HttpStatus.BAD_REQUEST);
        }
        //jednako praznom stringu, znaci da ne postoji vec polica sa tim imenom, znaci moze da se napravi nova polica sa tim nazivom
        if(citalacService.findByNaziv(policaDTO.getNaziv()).equals("")){
            Polica newPolica = new Polica();
            newPolica.setNaziv(policaDTO.getNaziv());
            newPolica.setPrimarna(false);
            newPolica.setStavkePolice(policaDTO.getStavkePolice());

            this.citalacService.save(newPolica);

            return ResponseEntity.ok(newPolica);
        }
        //u suprotnom, postoji polica sa tim nazivom pa se ne moze napraviti
        else return new ResponseEntity("Polica pod nazivom " + policaDTO.getNaziv() + " vec postoji.", HttpStatus.BAD_REQUEST);
    }
}
