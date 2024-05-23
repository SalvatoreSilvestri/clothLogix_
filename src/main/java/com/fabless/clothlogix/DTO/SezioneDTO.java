package com.fabless.clothlogix.DTO;

import lombok.Data;

@Data
public class SezioneDTO {
    private Long id;
    private String fila;
    private String scaffale;

    public SezioneDTO(){
    }

    public SezioneDTO(Long id, String fila, String scafale){
        this.id = id;
        this.fila = fila;
        this.scaffale = scafale;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getScaffale() {
        return scaffale;
    }

    public void setScaffale(String scafale) {
        this.scaffale = scafale;
    }
}
