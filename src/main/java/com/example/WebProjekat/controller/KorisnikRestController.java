package com.example.WebProjekat.controller;

import com.example.WebProjekat.dto.LoginDto;
import com.example.WebProjekat.dto.RegisterDTO;
import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Polica;
import com.example.WebProjekat.service.KnjigaService;
import com.example.WebProjekat.service.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class KorisnikRestController {
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/api")
    public String welcome(){
        return "Hello from api!";
    }

    //Registracija korisnika
    @PostMapping("/api/register")
    public String registrujKorisnika(@RequestBody RegisterDTO newDTO) {

        Korisnik newKorisnik = new Korisnik();
        newKorisnik.setIme(newDTO.getIme());
        newKorisnik.setPrezime(newDTO.getPrezime());
        newKorisnik.setKorisnickoIme(newDTO.getKorisnickoIme());
        newKorisnik.setEmail(newDTO.getEmail());
        newKorisnik.setLozinka(newDTO.getLozinka());
        newKorisnik.setDatumRodjenja(newDTO.getDatumRodjenja());
        newKorisnik.setUloga(newDTO.getUloga());

        Polica WTR = new Polica();
        WTR.setNaziv("Want to Read");
        WTR.setPrimarna(true);

        Polica CR = new Polica();
        CR.setNaziv("Currently Reading");
        CR.setPrimarna(true);

        Polica R = new Polica();
        R.setNaziv("Read");
        R.setPrimarna(true);

        Set<Polica> pocetnePolice = new HashSet<>();
        pocetnePolice.add(WTR);
        pocetnePolice.add(CR);
        pocetnePolice.add(R);

        newKorisnik.setPolice(pocetnePolice);

        this.korisnikService.save(newKorisnik);

        return "Korisnik" + newDTO.getKorisnickoIme() + "je uspesno registrovan.";
    }

    //Login korisnika
    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session) {
        //provera ispravnosti podataka
        if(loginDto.getKorisnickoIme().isEmpty() || loginDto.getLozinka().isEmpty())
            return new ResponseEntity("Polje ne sme biti prazno!", HttpStatus.BAD_REQUEST);

        Korisnik ulogovaniKorisnik = korisnikService.login(loginDto.getKorisnickoIme(), loginDto.getLozinka());
        if (ulogovaniKorisnik == null)
            return new ResponseEntity<>("Korisnik sa unetim podacima ne postoji!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", ulogovaniKorisnik);
        return ResponseEntity.ok("Korisnik " + ulogovaniKorisnik.getKorisnickoIme() + " je uspesno ulogovan.");
    }

    //Logout korisnika
    @PostMapping("/api/logout")
    public ResponseEntity Logout(HttpSession session){
        Korisnik ulogovaniKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (ulogovaniKorisnik == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Uspesno ste se izlogovali", HttpStatus.OK);
    }

    //Pregled svih knjiga od strane neregistrovanog korisnika
    @PostMapping("/api/pregled-knjiga")
    public ResponseEntity<List<Knjiga>> prikaziKnjigeZaNeregistrovanogKorisnika(HttpSession session) {
        List<Knjiga> sveKnjige = knjigaService.findAll();
        return ResponseEntity.ok(sveKnjige);
    }

    //Pretraga knjiga od strane neregistrovanog korisnika
    @PostMapping("/api/pregled-knjiga/pretraga")
    public ResponseEntity<List<Knjiga>> pretragaKnjigaZaNeregistrovanogKorisnika(HttpSession session) {
        String pretragaKnjige = new String();
        List<Knjiga> sveKnjigeUzPretragu = knjigaService.findAllByNaslovOrderById(pretragaKnjige);
        return ResponseEntity.ok(sveKnjigeUzPretragu);
    }

    //Pregled profila drugih korisnika od strane neregistrovanog korisnika

    //Pregled recenzija knjiga od strane neregistrovanog korisnika

    //Pretraga knjiga po zanru od strane neregistrovanog korisnika
}
