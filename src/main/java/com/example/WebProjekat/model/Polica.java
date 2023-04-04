package com.example.WebProjekat.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Polica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String naziv;

    @Column
    private Boolean primarna;


}
