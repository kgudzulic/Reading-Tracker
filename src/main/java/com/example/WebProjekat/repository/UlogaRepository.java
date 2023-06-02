package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UlogaRepository extends JpaRepository<Uloga, Long>{
    String getUlogaByNaziv(String nazivUloge);
}
