package com.example.WebProjekat.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ZahtevAktivacijeAutora implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String telefon;

    @Column
    private String poruka;

    @Column
    private Date datumZahteva;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private StatusAktivacije statusAktivacije;
}
