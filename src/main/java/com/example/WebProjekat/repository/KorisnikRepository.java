package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
    Korisnik findByKorisnickoIme(String korisnickoIme);

    Korisnik getBykorisnickoIme(String korisnickoIme);
}
