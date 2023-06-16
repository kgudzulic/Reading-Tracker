package com.example.WebProjekat.dto;

import com.example.WebProjekat.model.EnumUloga;
import com.example.WebProjekat.model.Polica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class IzmenaProfilaDTO {

    private String ime;

    private String prezime;

    private Date datumRodjenja;

    private String opis;

    private String slika;

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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }
}
