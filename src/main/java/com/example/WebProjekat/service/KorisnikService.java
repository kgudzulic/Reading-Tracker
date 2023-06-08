package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.ZahtevAktivacijeAutora;
import com.example.WebProjekat.model.Zanr;
import com.example.WebProjekat.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KnjigaService knjigaService;

    @Autowired
    private ZanrService zanrService;

    @Autowired
    private  ZahtevAktivacijeAutoraService zahtevAktivacijeAutoraService;

    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public Korisnik login(String korisnickoIme, String lozinka) {
        Korisnik korisnik = korisnikRepository.getBykorisnickoIme(korisnickoIme);
        if(korisnik == null || !korisnik.getLozinka().equals(lozinka))
            return null;
        return  korisnik;
    }

    public List<Korisnik> findAllUsers() {
        return (List<Korisnik>) korisnikRepository.findAll();
    }


    public List<Knjiga> findAllBooks(){
        return knjigaService.findAll();
    }

    public List<Knjiga> findByNaslov(String string) {
        return knjigaService.findByNaslov(string);
    }

    public List<Knjiga> findAllByNaslov(String string) {
        return knjigaService.findAllByNaslov(string);
    }

    public List<Knjiga> findByZanr_Naziv(String string) {
        return knjigaService.findByZanr_Naziv(string);
    }

    public Korisnik getByKorisnickoIme(String korisnickoIme){
        return korisnikRepository.getBykorisnickoIme(korisnickoIme);
    }

    public ZahtevAktivacijeAutora save(ZahtevAktivacijeAutora zahtev) {
        return zahtevAktivacijeAutoraService.save(zahtev);
    }

    public List<Zanr> findAllGenres(){
        return zanrService.findAll();
    }
}
