package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long>{
    List<Knjiga> findAllByNaslovOrOrderById(String naslov);
    List<Knjiga> findAllByOpisOrderById(String opis);
}

