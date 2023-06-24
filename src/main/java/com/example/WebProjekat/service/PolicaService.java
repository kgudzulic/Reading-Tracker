package com.example.WebProjekat.service;

import com.example.WebProjekat.dto.PolicaKnjigaDTO;
import com.example.WebProjekat.model.*;
import com.example.WebProjekat.repository.PolicaRepository;
import com.example.WebProjekat.repository.RecenzijaRepository;
import com.example.WebProjekat.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PolicaService {

    @Autowired
    private PolicaRepository policaRepository;

    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    @Autowired
    private RecenzijaRepository recenzijaRepository;

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

    public List<PolicaKnjigaDTO> sadrziKnjigu(Korisnik korisnik, Knjiga knjiga) {
        List<PolicaKnjigaDTO> policeKnjigaDTO = new ArrayList<>();

        List<Polica> police = findByKorisnik(korisnik);
        for(Polica polica: police) {
            boolean sadrzi = false;

            for (StavkaPolice stavka : polica.getStavkePolice()) {
                if (stavka.getKnjiga().getId().equals(knjiga.getId())) {
                    sadrzi = true; // Found a matching Knjiga in the Polica
                    break;
                }
            }
            policeKnjigaDTO.add(new PolicaKnjigaDTO(polica.getId(), polica.getNaziv(), sadrzi));
        }

        return policeKnjigaDTO;
    }

    public void otkloniKnjiguSaPolice(Polica polica, Knjiga knjiga){
        for(StavkaPolice stavkaPolice: polica.getStavkePolice()){
            if(stavkaPolice.getKnjiga().getId() == knjiga.getId()){
                if(polica.getNaziv().equals("Read")){
                    Recenzija recenzija = stavkaPolice.getRecenzija();
                    stavkaPolice.setRecenzija(null);
                    stavkaPoliceRepository.save(stavkaPolice);
                    recenzijaRepository.delete(recenzija);
                }
                polica.getStavkePolice().remove(stavkaPolice);
                break;
            }
        }
        save(polica);
    }
}

