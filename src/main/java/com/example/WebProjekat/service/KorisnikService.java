package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public Korisnik login(String korisnickoIme, String lozinka) {
        Korisnik korisnik = korisnikRepository.getBykorisnickoIme(korisnickoIme);
        if(korisnik == null || !korisnik.getLozinka().equals(lozinka))
            return null;
        return  korisnik;
    }

    public List<Korisnik> findAll() {
        return (List<Korisnik>) korisnikRepository.findAll();
    }

    public List<Korisnik> findAllByKorisnickoImeOrderByIme(String string) {
        return (List<Korisnik>) korisnikRepository.findAllByKorisnickoImeOrderByIme(string);
    }
}
