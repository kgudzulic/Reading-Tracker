package com.example.WebProjekat.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Polica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String naziv;

    @Column
    private Boolean primarna;


    //prvi deo many to many tabele izmedju stavki police i same police
    @ManyToMany
    @jakarta.persistence.JoinTable(name = "pripada",
            joinColumns = @jakarta.persistence.JoinColumn(name = "polica_id", referencedColumnName = "id"),
            inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "stavkaPolice_id", referencedColumnName = "id"))
    private Set<StavkaPolice> stavkePolice = new HashSet<>();

    /*@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Korisnik korisnik;*/

    public Polica() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Boolean getPrimarna() {
        return primarna;
    }

    public void setPrimarna(Boolean primarna) {
        this.primarna = primarna;
    }

    public Set<StavkaPolice> getStavkePolice() {
        return stavkePolice;
    }

    public void setStavkePolice(Set<StavkaPolice> stavkePolice) {
        this.stavkePolice = stavkePolice;
    }
}
