package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Recenzija;
import com.example.WebProjekat.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;

    public List<Recenzija> findAll(){
        return recenzijaRepository.findAll();
    }
}
