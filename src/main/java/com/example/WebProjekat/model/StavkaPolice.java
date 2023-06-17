package com.example.WebProjekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StavkaPolice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Recenzija recenzija;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Knjiga knjiga;

    @ManyToMany(mappedBy = "stavkePolice")
    @JsonIgnore
    private Set<Polica> police = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Recenzija recenzija) {
        this.recenzija = recenzija;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Set<Polica> getPolice() {
        return police;
    }

    public void setPolice(Set<Polica> police) {
        this.police = police;
    }
}
