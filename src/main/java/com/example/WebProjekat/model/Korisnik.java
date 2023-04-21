package com.example.WebProjekat.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(unique = true)
    private String korisnickoIme;

    @Column(unique = true)
    private String email;

    @Column
    private String lozinka;

    @Column
    private Date datumRodjenja;

    @Column
    private Object profilnaSlika;

    @Column
    private String opis;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Uloga uloga;

    @OneToMany(mappedBy = "korisnik", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Polica> police = new HashSet<>();
}
