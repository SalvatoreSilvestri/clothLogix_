package com.fabless.clothlogix.DTO;

import com.fabless.clothlogix.Entity.ColoreEntity;
import com.fabless.clothlogix.Entity.MaterialeEntity;
import com.fabless.clothlogix.Entity.SezioneEntity;
import com.fabless.clothlogix.Entity.enums.Taglia;
import com.fabless.clothlogix.Entity.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Set;

@Data
public class ProdottoDTO {

    private Long id;

    private String descrizione;

    private Integer prezzo;

    private String codiceProdotto;

    private Tipo tipo;

    private Taglia taglia;

    private ColoreEntity colore;

//    @JsonIgnore
    private Set<MaterialeEntity> materiali;


    private SezioneEntity sezione;


    public ProdottoDTO() {}

    public ProdottoDTO(Long id, String descrizione, Integer prezzo, String codiceProdotto, Tipo tipo, Taglia taglia, ColoreEntity colore, Set<MaterialeEntity> materiali, SezioneEntity sezione) {
        this.id = id;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.codiceProdotto = codiceProdotto;
        this.tipo = tipo;
        this.taglia = taglia;
        this.colore = colore;
        this.materiali = materiali;
        this.sezione = sezione;
    }
}
