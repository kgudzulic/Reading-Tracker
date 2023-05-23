package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
    Korisnik findByKorisnickoImeOrderByIme(String korisnickoIme);

    Korisnik getBykorisnickoIme(String korisnickoIme);

    Korisnik getALL();
}
