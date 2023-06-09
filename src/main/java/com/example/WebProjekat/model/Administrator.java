package com.example.WebProjekat.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
//@DiscriminatorValue("ADMINISTRATOR")
public class Administrator extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Administrator(String ime, String prezime) {
        super(ime, prezime);
        this.id = id;
    }

    public Administrator() {

    }
}
