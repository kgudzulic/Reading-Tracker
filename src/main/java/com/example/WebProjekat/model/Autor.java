package com.example.WebProjekat.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@DiscriminatorValue("AUTOR")
public class Autor extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean aktivan;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Knjiga> spisakKnjiga = new HashSet<>();

    public Autor(String ime, String prezime) {
        super(ime, prezime);
    }

    public Autor() {
    }
}
