package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Polica;
import com.example.WebProjekat.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicaService {

    @Autowired
    private PolicaRepository policaRepository;

    public void deletePolicaByNaziv(String naziv){
        policaRepository.deletePolicaByNaziv(naziv);
    }

    public List<Polica> findAll(){
        return policaRepository.findAll();
    }

    public Polica findByNaziv(String nazivPolice){
        return policaRepository.findByNaziv(nazivPolice);
    }

    public Polica save(Polica polica) {
        return policaRepository.save(polica);
    }
}

