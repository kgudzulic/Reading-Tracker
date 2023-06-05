package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Zanr;
import com.example.WebProjekat.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZanrService {
    @Autowired
    private ZanrRepository zanrRepository;

    public List<Zanr> findAll(){
        return zanrRepository.findAll();
    }
}
