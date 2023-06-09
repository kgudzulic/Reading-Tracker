package com.example.WebProjekat.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
//@DiscriminatorValue("CITALAC")
public class Citalac extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Citalac(String ime, String prezime) {
        super(ime, prezime);
        this.id = id;
    }

    public Citalac() {

    }


}
