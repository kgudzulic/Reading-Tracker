package com.example.WebProjekat.controller;

import com.example.WebProjekat.dto.*;
import com.example.WebProjekat.model.*;
import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.service.KorisnikService;
import com.example.WebProjekat.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/korisnici")
public class KorisnikRestController {
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private PolicaService policaService;


    @GetMapping
    public ResponseEntity<List<Korisnik>> get(HttpSession session) {
        List<Korisnik> sviKorisnici = korisnikService.findAll();
        return ResponseEntity.ok(sviKorisnici);
    }

    @PostMapping("/zahtev-aktivacije-autora")
    public String zahtevAktivacije(@RequestBody ZahtevAktivacijeAutoraDTO newZahtevDTO) {

        ZahtevAktivacijeAutora noviZahtev = new ZahtevAktivacijeAutora();
        noviZahtev.setAutor(newZahtevDTO.getAutor());
        noviZahtev.setEmail(newZahtevDTO.getEmail());
        noviZahtev.setEmail(newZahtevDTO.getEmail());
        noviZahtev.setPoruka(newZahtevDTO.getPoruka());
        noviZahtev.setDatumZahteva(newZahtevDTO.getDatumZahteva());
        noviZahtev.setTelefon(newZahtevDTO.getTelefon());

        this.korisnikService.save(noviZahtev);

        return "Zahtev za aktivaciju naloga autora" + noviZahtev.getAutor().getKorisnickoIme() + "je uspesno podnet.";
    }

    @GetMapping("{id}")
    public ResponseEntity<Korisnik> getUser(@PathVariable long id){
        Optional<Korisnik> optionalKorisnik = korisnikService.findById(id);
        if(optionalKorisnik.isPresent()){
            Korisnik korisnik = optionalKorisnik.get();
            return ResponseEntity.ok(korisnik);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Korisnik> updateUser(@RequestBody IzmenaProfilaDTO izmenaProfilaDTO, @PathVariable long id){
        Optional<Korisnik> optionalKorisnik = korisnikService.findById(id);
        if(optionalKorisnik.isPresent()){
            Korisnik korisnik = optionalKorisnik.get();
            korisnik.setIme(izmenaProfilaDTO.getIme());
            korisnik.setPrezime(izmenaProfilaDTO.getPrezime());
            korisnik.setDatumRodjenja(izmenaProfilaDTO.getDatumRodjenja());
            korisnik.setOpis(izmenaProfilaDTO.getOpis());
            korisnik.setProfilnaSlika(izmenaProfilaDTO.getSlika());
            korisnikService.save(korisnik);
            return ResponseEntity.ok(korisnik);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}/email")
    public ResponseEntity<Korisnik> updateUserEmail(@RequestBody IzmenaEmailDTO izmenaEmailDTO, @PathVariable long id){
        Optional<Korisnik> optionalKorisnik = korisnikService.findById(id);
        if(optionalKorisnik.isPresent()){
            Korisnik korisnik = optionalKorisnik.get();
            if( !korisnik.getLozinka().equals(izmenaEmailDTO.getStaraLozinka())){
                return  ResponseEntity.badRequest().build();
            }
            korisnik.setEmail(izmenaEmailDTO.getEmail());
            return ResponseEntity.ok(korisnik);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}/password")
    public ResponseEntity<Korisnik> updateUserPsssword(@RequestBody IzmenaLozinkeDTO izmenaLozinkeDTO, @PathVariable long id){
        Optional<Korisnik> optionalKorisnik = korisnikService.findById(id);
        if(optionalKorisnik.isPresent()){
            Korisnik korisnik = optionalKorisnik.get();
            if(!izmenaLozinkeDTO.getLozinka().equals(izmenaLozinkeDTO.getLozinkaPotvrda())  || !korisnik.getLozinka().equals(izmenaLozinkeDTO.getStaraLozinka())){
                return  ResponseEntity.badRequest().build();
            }
            korisnik.setLozinka(izmenaLozinkeDTO.getLozinka());
            return ResponseEntity.ok(korisnik);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}/police")
    public ResponseEntity<List<Polica>> getPoliceByUser(@PathVariable long id){
        Optional<Korisnik> optionalKorisnik = korisnikService.findById(id);
        if(optionalKorisnik.isPresent()){
            Korisnik korisnik = optionalKorisnik.get();
            List<Polica> police = policaService.findByKorisnik(korisnik);
            return ResponseEntity.ok(police);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("{id}/police")
    public ResponseEntity<Polica> postPolicAByUser(@PathVariable long id, @RequestBody PolicaDTO policaDTO){
        Optional<Korisnik> optionalKorisnik = korisnikService.findById(id);
        if(optionalKorisnik.isPresent()){
            Korisnik korisnik = optionalKorisnik.get();
            Polica polica = new Polica();
            polica.setNaziv(policaDTO.getNaziv());
            polica.setPrimarna(false);
            polica.setKorisnik(korisnik);
            Polica savedPolica = policaService.save(polica);
            return ResponseEntity.ok(savedPolica);
        }
        return ResponseEntity.notFound().build();
    }
}
