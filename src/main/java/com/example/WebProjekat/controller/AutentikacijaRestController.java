package com.example.WebProjekat.controller;

import com.example.WebProjekat.dto.LoginDTO;
import com.example.WebProjekat.dto.RegisterDTO;
import com.example.WebProjekat.model.EnumUloga;
import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Polica;
import com.example.WebProjekat.service.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/autentikacija")
public class AutentikacijaRestController {
    @Autowired
    private KorisnikService korisnikService;

    @PostMapping("register")
    public Korisnik registrujKorisnika(@RequestBody RegisterDTO newDTO) {

        Korisnik newKorisnik = new Korisnik();

        newKorisnik.setIme(newDTO.getIme());
        newKorisnik.setPrezime(newDTO.getPrezime());
        newKorisnik.setKorisnickoIme(newDTO.getKorisnickoIme());
        newKorisnik.setEmail(newDTO.getEmail());
        newKorisnik.setLozinka(newDTO.getLozinka());
        newKorisnik.setDatumRodjenja(newDTO.getDatumRodjenja());
        newKorisnik.setUloga(EnumUloga.CITALAC);

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

        return newKorisnik;
    }

    //Login korisnika
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDto, HttpSession session) {
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
    @PostMapping("logout")
    public ResponseEntity Logout(HttpSession session){
        Korisnik ulogovaniKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (ulogovaniKorisnik == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Uspesno ste se izlogovali", HttpStatus.OK);
    }
}
