package com.example.WebProjekat.dto;

public class StavkaPoliceDTO {
    private long knjigaId;

    private RecenzijaDTO recenzijaDTO;

    public long getKnjigaId() {
        return knjigaId;
    }

    public void setKnjigaId(long knjigaId) {
        this.knjigaId = knjigaId;
    }

    public RecenzijaDTO getRecenzijaDTO() {
        return recenzijaDTO;
    }

    public void setRecenzijaDTO(RecenzijaDTO recenzijaDTO) {
        this.recenzijaDTO = recenzijaDTO;
    }
}
