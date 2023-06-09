package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Recenzija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecenzijaRepository extends JpaRepository<Recenzija, Long>{
    List<Recenzija> findAll();
}
