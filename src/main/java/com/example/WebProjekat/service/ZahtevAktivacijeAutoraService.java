package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.ZahtevAktivacijeAutora;
import com.example.WebProjekat.repository.ZahtevAktivacijeAutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

@Service
public class ZahtevAktivacijeAutoraService {
    @Autowired
    private ZahtevAktivacijeAutoraRepository zahtevAktivacijeAutoraRepository;
    public ZahtevAktivacijeAutora save(ZahtevAktivacijeAutora zahtev) {
        return zahtevAktivacijeAutoraRepository.save(zahtev);
    }
}
