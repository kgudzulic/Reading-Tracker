package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZanrRepository extends JpaRepository<Zanr, Long>{
}
