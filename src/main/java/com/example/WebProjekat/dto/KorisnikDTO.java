package com.example.WebProjekat.dto;

import com.example.WebProjekat.model.EnumUloga;
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

    private String korisnickoIme;

    private Date datumRodjenja;

    private EnumUloga uloga;

    private Set<Polica> police = new HashSet<>();

    public KorisnikDTO() {
    }

    public KorisnikDTO(String ime, String prezime, String korisnickoIme, Date datumRodjenja, EnumUloga uloga, Set<Polica> police) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
        this.police = police;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public EnumUloga getUloga() {
        return uloga;
    }

    public void setUloga(EnumUloga uloga) {
        this.uloga = uloga;
    }

    public Set<Polica> getPolice() {
        return police;
    }

    public void setPolice(Set<Polica> police) {
        this.police = police;
    }
}
