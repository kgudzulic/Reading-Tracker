package com.example.WebProjekat.dto;

public class IzmenaLozinkeDTO {
    private String lozinka;

    private String lozinkaPotvrda;

    private String staraLozinka;

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getLozinkaPotvrda() {
        return lozinkaPotvrda;
    }

    public void setLozinkaPotvrda(String lozinkaPotvrda) {
        this.lozinkaPotvrda = lozinkaPotvrda;
    }

    public String getStaraLozinka() {
        return staraLozinka;
    }

    public void setStaraLozinka(String staraLozinka) {
        this.staraLozinka = staraLozinka;
    }
}
