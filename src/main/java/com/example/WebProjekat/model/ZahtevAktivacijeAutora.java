package com.example.WebProjekat.model;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
public class ZahtevAktivacijeAutora implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
