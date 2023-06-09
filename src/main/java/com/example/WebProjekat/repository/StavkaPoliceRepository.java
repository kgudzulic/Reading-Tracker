package com.example.WebProjekat.repository;

import com.example.WebProjekat.model.StavkaPolice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StavkaPoliceRepository extends JpaRepository<StavkaPolice, Long>{

    List<StavkaPolice> findAll();
}
