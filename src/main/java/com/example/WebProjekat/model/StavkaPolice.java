package com.example.WebProjekat.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StavkaPolice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //stavka police ima vise recenzija, znaci 1:M veza
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Recenzija> recenzije = new HashSet<>();

    //jedna stavka police karakterise jednu knjigu tj 1:1 veza
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Knjiga knjiga;

    /*
    //drugi deo many to many tabele izmedju stavki police i same police
    @ManyToMany(mappedBy = "stavkePolice")
    private Set<Polica> police = new HashSet<>();*/
}
