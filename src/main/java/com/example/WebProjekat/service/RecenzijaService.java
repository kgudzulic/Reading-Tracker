package com.example.WebProjekat.service;

import com.example.WebProjekat.model.Knjiga;
import com.example.WebProjekat.model.Recenzija;
import com.example.WebProjekat.repository.RecenzijaRepository;
import com.example.WebProjekat.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;

    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    public List<Recenzija> findAll(){
        return recenzijaRepository.findAll();
    }

    public List<Recenzija> findAllRecenzijaByKnjiga(Knjiga knjiga){
        return recenzijaRepository.findAllRecenzijaByKnjiga(knjiga);
    }

    public Optional<Recenzija> findById(long id) {
        return recenzijaRepository.findById(id);
    }

    public Recenzija save(Recenzija recenzija) {
        return recenzijaRepository.save(recenzija);
    }
}
