package com.example.WebProjekat.controller;

import com.example.WebProjekat.dto.KorisnikDTO;
import com.example.WebProjekat.dto.RegisterDTO;
import com.example.WebProjekat.model.Autor;
import com.example.WebProjekat.model.EnumUloga;
import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Polica;
import com.example.WebProjekat.service.AdministratorService;
import com.example.WebProjekat.service.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class AdministratorRestController {
    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private KorisnikService korisnikService;

    @PostMapping("/api/administrator/create-autor")
    public ResponseEntity<Korisnik> kreirajAutora(@RequestBody RegisterDTO newDTO, HttpSession session) {
        KorisnikDTO ulogovaniKorisnik = (KorisnikDTO) session.getAttribute("Korisnik");

        if(ulogovaniKorisnik == null){
            return new ResponseEntity("Niste ulogovani.", HttpStatus.BAD_REQUEST);
        }
        if(ulogovaniKorisnik.getUloga() != EnumUloga.CITALAC){
            return new ResponseEntity("Dodavanje police nije moguce, neispravna uloga.", HttpStatus.BAD_REQUEST);
        }

        Autor newKorisnik = new Autor();
        newKorisnik.setIme(newDTO.getIme());
        newKorisnik.setPrezime(newDTO.getPrezime());
        newKorisnik.setKorisnickoIme(newDTO.getKorisnickoIme());
        newKorisnik.setEmail(newDTO.getEmail());
        newKorisnik.setLozinka(newDTO.getLozinka());
        newKorisnik.setDatumRodjenja(newDTO.getDatumRodjenja());
        newKorisnik.setUloga(EnumUloga.AUTOR);

        Polica WTR = new Polica();
        WTR.setNaziv("Want to Read_" + newKorisnik.getKorisnickoIme());
        WTR.setPrimarna(true);

        Polica CR = new Polica();
        CR.setNaziv("Currently Reading_" + newKorisnik.getKorisnickoIme());
        CR.setPrimarna(true);

        Polica R = new Polica();
        R.setNaziv("Read_" + newKorisnik.getKorisnickoIme());
        R.setPrimarna(true);

        Set<Polica> pocetnePolice = new HashSet<>();
        pocetnePolice.add(WTR);
        pocetnePolice.add(CR);
        pocetnePolice.add(R);

        newKorisnik.setPolice(pocetnePolice);

        this.korisnikService.save(newKorisnik);

        return ResponseEntity.ok(newKorisnik);
    }
}
