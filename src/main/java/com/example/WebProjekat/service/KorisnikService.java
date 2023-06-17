package com.example.WebProjekat.service;

import com.example.WebProjekat.model.*;
import com.example.WebProjekat.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KnjigaService knjigaService;

    @Autowired
    private ZanrService zanrService;

    @Autowired
    private ZahtevAktivacijeAutoraService zahtevAktivacijeAutoraService;

    @Autowired
    private PolicaService policaService;

    @Autowired
    private RecenzijaService recenzijaService;

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

        return korisnikRepository.findAll();
    }

    public List<Polica> findAllPolice() {
        return policaService.findAll();
    }

    public List<Recenzija> findAllRecenzije() {
        return recenzijaService.findAll();
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

    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    public Optional<Korisnik> findById(long id) {
        return korisnikRepository.findById(id);
    }
}
