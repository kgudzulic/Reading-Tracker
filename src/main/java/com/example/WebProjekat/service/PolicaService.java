package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Polica;
import com.example.WebProjekat.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicaService {

    @Autowired
    private PolicaRepository policaRepository;

    public void deletePolicaByNaziv(String naziv){
        policaRepository.deletePolicaByNaziv(naziv);
    }
}
