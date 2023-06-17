package com.example.WebProjekat.dto;

import com.example.WebProjekat.model.Uloga;

import java.util.Date;

public class RegisterDTO {
    private String ime;

    private String prezime;

    private String korisnickoIme;

    private String email;

    private String lozinka;

    private String lozinkaPotvrda;

    private Date datumRodjenja = new Date();

    public RegisterDTO() {
    }

    public RegisterDTO(String korisnickoIme, String lozinka, String ime, String prezime, String email, Date datumRodjenja/*, Uloga uloga*/) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getLozinkaPotvrda() {
        return lozinkaPotvrda;
    }

    public void setLozinkaPotvrda(String lozinkaPotvrda) {
        this.lozinkaPotvrda = lozinkaPotvrda;
    }
}
