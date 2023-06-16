package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Recenzija;
import com.example.WebProjekat.model.StavkaPolice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StavkaPoliceRepository extends JpaRepository<StavkaPolice, Long> {

    List<StavkaPolice> findAll();

    @Query("SELECT COUNT(sp) > 0 FROM StavkaPolice sp JOIN sp.police p WHERE p.korisnik = :korisnik AND p.primarna = true AND sp.knjiga = :knjiga")
    boolean postojiKnjigaNaPrimarnojPolici(@Param("korisnik") Korisnik korisnik, @Param("knjiga") Knjiga knjiga);

}
