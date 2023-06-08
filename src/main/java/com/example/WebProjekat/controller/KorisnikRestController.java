package com.example.WebProjekat.controller;

import com.example.WebProjekat.dto.*;
import com.example.WebProjekat.model.*;
import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Polica;
import com.example.WebProjekat.service.KnjigaService;
import com.example.WebProjekat.service.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class KorisnikRestController {
    @Autowired
    private KorisnikService korisnikService;

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
        if(newDTO.getUloga().getNaziv() != "citalac")
        {
            return "Jedino se mozete registrovati kao citalac.";
        }
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
    @PostMapping("/api/logout")
    public ResponseEntity Logout(HttpSession session){
        Korisnik ulogovaniKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (ulogovaniKorisnik == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Uspesno ste se izlogovali", HttpStatus.OK);
    }

    //Pregled svih knjiga od strane neregistrovanog korisnika
    @GetMapping("/api/pregled-knjiga")
    public ResponseEntity<List<Knjiga>> prikaziKnjige(HttpSession session) {
        List<Knjiga> sveKnjige = korisnikService.findAllBooks();
        return ResponseEntity.ok(sveKnjige);
    }

    //Pretraga knjiga od strane neregistrovanog korisnika
    @GetMapping("/api/pregled-knjiga/pretraga-naslov")
    public ResponseEntity<List<Knjiga>> pretragaKnjigaPoNaslovu(@RequestParam("naslov") String naslov) {
        return ResponseEntity.ok(korisnikService.findByNaslov(naslov));
    }

    //Pregled profila drugih korisnika od strane neregistrovanog korisnika
    @GetMapping("/api/pregled-profila")
    public ResponseEntity<List<Korisnik>> prikaziKorisnika(HttpSession session) {
        List<Korisnik> sviKorisnici = korisnikService.findAllUsers();
        return ResponseEntity.ok(sviKorisnici);
    }

    //Pretraga korisnika od strane neregistrovanog korisnika
    @GetMapping("/api/pregled-profila/pretraga")
    public ResponseEntity<Korisnik> pretragaKorisnika(@RequestParam("korisnickoIme") String korisnickoIme) {
        return ResponseEntity.ok(korisnikService.getByKorisnickoIme(korisnickoIme));
    }

    //Pretraga knjiga po zanru od strane neregistrovanog korisnika
    @GetMapping("/api/pregled-knjiga/pretraga-zanr")
    public ResponseEntity<List<Knjiga>> pretragaKnjigaPoZanru(@RequestParam("naziv") String zanr) {
        return ResponseEntity.ok(korisnikService.findByZanr_Naziv(zanr));
    }

    //Podnosenje zahteva za aktivaciju autora
    // TO DO : potrebna validacija podataka da li postoji autor sa unetim podacima kom nalog nije aktivan
    @PostMapping("/api/zahtev-aktivacije-autora")
    public String zahtevAktivacije(@RequestBody ZahtevAktivacijeAutoraDTO newZahtevDTO) {

        ZahtevAktivacijeAutora noviZahtev = new ZahtevAktivacijeAutora();
        noviZahtev.setAutor(newZahtevDTO.getAutor());
        noviZahtev.setEmail(newZahtevDTO.getEmail());
        noviZahtev.setEmail(newZahtevDTO.getEmail());
        noviZahtev.setPoruka(newZahtevDTO.getPoruka());
        noviZahtev.setDatumZahteva(newZahtevDTO.getDatumZahteva());
        noviZahtev.setTelefon(newZahtevDTO.getTelefon());

        this.korisnikService.save(noviZahtev);

        return "Zahtev za aktivaciju naloga autora" + noviZahtev.getAutor().getKorisnickoIme() + "je uspesno podnet.";
    }

    //Pregled recenzija


    //Pregled zanrova
    @GetMapping("/api/pregled-zanrova")
    public ResponseEntity<List<Zanr>> prikazZanrova(HttpSession session) {
        List<Zanr> sviZanrovi = korisnikService.findAllGenres();
        return ResponseEntity.ok(sviZanrovi);
    }

    //Pregled polica korisnika
}
