package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.model.Recenzija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecenzijaRepository extends JpaRepository<Recenzija, Long>{
    List<Recenzija> findAll();

    @Query("SELECT sp.recenzija FROM StavkaPolice sp WHERE sp.knjiga = :knjiga")
    List<Recenzija> findAllRecenzijaByKnjiga(@Param("knjiga") Knjiga knjiga);

}
