package com.fabless.clothlogix.Entity;


import com.fabless.clothlogix.Entity.enums.Taglia;
import com.fabless.clothlogix.Entity.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "prodotto")
public class ProdottoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "prezzo")
    private Integer prezzo;

    @Column(name = "codice_prodotto")
    private String codiceProdotto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "taglia", nullable = false)
    private Taglia taglia;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
    name = "prodotto_colore_rel",
            joinColumns = @JoinColumn(name = "id_prodotto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_colore", referencedColumnName = "id")
    )
    private Set<ColoreEntity> colori;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "prodotto_materiale_rel",
            joinColumns = @JoinColumn(name = "id_prodotto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_materiale", referencedColumnName = "id")
    )
    private Set<MaterialeEntity> materiali;


    @ManyToOne
    @JoinColumn(name = "id_sezione")
    private SezioneEntity sezioni;


    public ProdottoEntity() {}

    public ProdottoEntity(Long id, String descrizione, Integer prezzo, String codiceProdotto, Tipo tipo, Taglia taglia, Set<ColoreEntity> colori, Set<MaterialeEntity> materiali, SezioneEntity sezioni) {
        this.id = id;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.codiceProdotto = codiceProdotto;
        this.tipo = tipo;
        this.taglia = taglia;
        this.colori = colori;
        this.materiali = materiali;
        this.sezioni = sezioni;
    }
}

