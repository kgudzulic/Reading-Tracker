package com.example.WebProjekat.model;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Knjiga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naslov;

    /*@Column
    private Object naslovnaFotografija;*/

    @Column(unique = true)
    private String ISBN;

    @Column
    private Date datumObjavljivanja;

    @Column
    private Long brojStrana;

    @Column
    private String opis;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Zanr zanr;

    @Column
    private Long srednjaOcena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(Date datumObjavljivanja) {
        this.datumObjavljivanja = datumObjavljivanja;
    }

    public Long getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(Long brojStrana) {
        this.brojStrana = brojStrana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public Long getSrednjaOcena() {
        return srednjaOcena;
    }

    public void setSrednjaOcena(Long srednjaOcena) {
        this.srednjaOcena = srednjaOcena;
    }
}
