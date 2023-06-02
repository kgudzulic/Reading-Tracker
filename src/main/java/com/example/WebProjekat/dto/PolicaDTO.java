package com.example.WebProjekat.dto;

import com.example.WebProjekat.model.StavkaPolice;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class PolicaDTO {
    private Long id;

    private String naziv;

    private Boolean primarna;

    private Set<StavkaPolice> stavkePolice = new HashSet<>();

    /*@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Korisnik korisnik;*/

    public PolicaDTO() {
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
