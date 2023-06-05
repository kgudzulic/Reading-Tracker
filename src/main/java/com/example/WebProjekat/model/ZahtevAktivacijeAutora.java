package com.example.WebProjekat.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ZahtevAktivacijeAutora implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String telefon;

    @Column
    private String poruka;

    @Column
    private Date datumZahteva;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private StatusAktivacije statusAktivacije;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
}
