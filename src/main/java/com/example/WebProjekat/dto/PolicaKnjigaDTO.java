package com.example.WebProjekat.dto;

public class PolicaKnjigaDTO {

    private Long id;

    private String naziv;

    private Boolean sadrzi;

    public PolicaKnjigaDTO(Long id, String naziv, Boolean sadrzi) {
        this.id = id;
        this.naziv = naziv;
        this.sadrzi = sadrzi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Boolean getSadrzi() {
        return sadrzi;
    }

    public void setSadrzi(Boolean sadrzi) {
        this.sadrzi = sadrzi;
    }
}
