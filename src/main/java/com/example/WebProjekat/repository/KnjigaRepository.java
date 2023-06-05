package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.model.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long>{
    List<Knjiga> findAllByNaslov(String naslov);

    List<Knjiga> findByNaslov(String naslov);

    List<Knjiga> findAll();

    List<Knjiga> findByZanr_Naziv(String zanr);
}

