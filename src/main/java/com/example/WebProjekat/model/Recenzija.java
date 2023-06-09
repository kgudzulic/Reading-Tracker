package com.example.WebProjekat.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Recenzija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer ocena;

    @Column
    private String tekst;

    @Column
    private Date datumRecenzije;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Korisnik korisnik;

    public Recenzija(Integer ocena, String tekst, Date datumRecenzije, Korisnik korisnik) {
        this.ocena = ocena;
        this.tekst = tekst;
        this.datumRecenzije = datumRecenzije;
        this.korisnik = korisnik;
    }
}
