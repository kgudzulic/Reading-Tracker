package com.example.WebProjekat.dto;

import com.example.WebProjekat.model.Autor;
import com.example.WebProjekat.model.StatusAktivacije;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class ZahtevAktivacijeAutoraDTO {
    private Long id;

    private String email;

    private String telefon;

    private String poruka;

    private Date datumZahteva;

    private StatusAktivacije statusAktivacije;

    private Autor autor;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Date getDatumZahteva() {
        return datumZahteva;
    }

    public void setDatumZahteva(Date datumZahteva) {
        this.datumZahteva = datumZahteva;
    }

    public StatusAktivacije getStatusAktivacije() {
        return statusAktivacije;
    }

    public void setStatusAktivacije(StatusAktivacije statusAktivacije) {
        this.statusAktivacije = statusAktivacije;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public ZahtevAktivacijeAutoraDTO() {
    }

    public ZahtevAktivacijeAutoraDTO(String email, String telefon, String poruka, Date datumZahteva, StatusAktivacije statusAktivacije, Autor autor) {
        this.email = email;
        this.telefon = telefon;
        this.poruka = poruka;
        this.datumZahteva = datumZahteva;
        this.statusAktivacije = statusAktivacije;
        this.autor = autor;
    }
}
