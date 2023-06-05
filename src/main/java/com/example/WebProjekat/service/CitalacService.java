package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Polica;
import com.example.WebProjekat.repository.CitalacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitalacService {
    @Autowired
    private CitalacRepository citalacRepository;

    @Autowired
    private UlogaService ulogaService;

    @Autowired
    private PolicaService policaService;

    public String getUlogaByNaziv(String nazivUloge){
        return ulogaService.getUlogaByNaziv(nazivUloge);
    }

    public Polica findByNaziv(String nazivPolice){
        return policaService.findByNaziv(nazivPolice);
    }

    public Polica save(Polica polica) {
        return policaService.save(polica);
    }

    public void deletePolicaByNaziv(String naziv){
        policaService.deletePolicaByNaziv(naziv);
    }
}
