package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Polica;
import com.example.WebProjekat.repository.PolicaRepository;
import com.example.WebProjekat.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicaService {

    @Autowired
    private PolicaRepository policaRepository;

    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    public void deletePolicaByNaziv(String naziv){
        policaRepository.deletePolicaByNaziv(naziv);
    }

    public List<Polica> findAll(){
        return policaRepository.findAll();
    }

    /*public List<Polica> findAllByKorisnik(Korisnik k){
        return policaRepository.findAllByKorisnik(k);
    }*/

    public Polica findByNaziv(String nazivPolice){
        return policaRepository.findByNaziv(nazivPolice);
    }

    public Polica save(Polica polica) {
        return policaRepository.save(polica);
    }

    public List<Polica> findByKorisnik(Korisnik korisnik) {

        return policaRepository.findByKorisnik(korisnik);
    }

    public Optional<Polica> findById(long id) {
        return policaRepository.findById(id);
    }

    public void delete(Polica polica) {
        policaRepository.delete(polica);
    }

    public boolean postojiKnjigaNaPrimarnojPolici( Korisnik korisnik,  Knjiga knjiga){
        return stavkaPoliceRepository.postojiKnjigaNaPrimarnojPolici(korisnik, knjiga);
    }
}

