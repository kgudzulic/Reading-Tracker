package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }
}
