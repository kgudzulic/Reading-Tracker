package com.example.WebProjekat.dto;

import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.model.Polica;
import com.example.WebProjekat.model.Uloga;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class KorisnikDTO {
    private Long id;

    private String ime;

    private String prezime;

    private Date datumRodjenja;

    private Uloga uloga;

    private Set<Polica> police = new HashSet<>();

    public KorisnikDTO() {
    }

    public KorisnikDTO(String ime, String prezime, Date datumRodjenja, Uloga uloga, Set<Polica> police) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
        this.police = police;
    }

    public KorisnikDTO(Korisnik korisnik) {
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.datumRodjenja = korisnik.getDatumRodjenja();
        this.uloga = korisnik.getUloga();
        this.police = korisnik.getPolice();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public Set<Polica> getPolice() {
        return police;
    }

    public void setPolice(Set<Polica> police) {
        this.police = police;
    }
}
