package com.fabless.clothlogix.DTO;

import lombok.Data;

/**
 * Data Transfer Object per l'entità Colore.
 * Utilizzato per trasferire dati tra livelli senza esporre dettagli dell'entità.
 */
@Data
public class ColoreDTO {

    private Long id; // Identificatore unico per il colore, corrispondente all'entity
    private String descrizione; // Descrizione del colore

    // Costruttori
    public ColoreDTO() {
    }

    public ColoreDTO(Long id, String descrizione) {
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

    // Metodo toString per rappresentazione testuale, utile per il debugging

}