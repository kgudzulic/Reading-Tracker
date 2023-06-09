package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{

    Korisnik getBykorisnickoIme(String korisnickoIme);

    List<Korisnik> findAll();

}
