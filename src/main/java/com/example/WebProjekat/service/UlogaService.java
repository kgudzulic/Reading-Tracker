package com.example.WebProjekat.service;

import com.example.WebProjekat.repository.UlogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UlogaService {
    @Autowired
    private UlogaRepository ulogaRepository;

    public String getUlogaByNaziv(String nazivUloge){
        return ulogaRepository.getUlogaByNaziv(nazivUloge);
    }
}
