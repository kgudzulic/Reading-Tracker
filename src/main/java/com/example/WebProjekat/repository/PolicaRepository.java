package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Polica;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PolicaRepository extends JpaRepository<Polica, Long>{
    void deletePolicaByNaziv(String naziv);
}
