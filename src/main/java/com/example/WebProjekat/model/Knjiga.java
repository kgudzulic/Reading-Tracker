package com.example.WebProjekat.model;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Knjiga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naslov;

    @Column
    private Object naslovnaFotografija;

    @Column(unique = true)
    private Long ISBN;

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
}
