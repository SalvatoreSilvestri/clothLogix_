package com.fabless.clothlogix.DTO;

public class MaterialeDTO {
    private Long id; // Identificatore unico per il colore, corrispondente all'entity
    private String descrizione; // Descrizione del colore

    // Costruttori
    public MaterialeDTO() {
    }

    public MaterialeDTO(Long id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
