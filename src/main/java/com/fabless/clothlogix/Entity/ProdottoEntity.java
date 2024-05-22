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

    /*@JsonManagedReference
    @ManyToOne
    @JoinTable(
    name = "prodotto_colore_rel",
            joinColumns = @JoinColumn(name = "id_prodotto"))
    private Set<ColoreEntity> colori;
*/

    @ManyToOne
    @JoinColumn(name = "id_colore")
    private ColoreEntity colore;


    @OneToMany
    @JoinColumn(name = "id_materiale")
    private Set<MaterialeEntity> materiali;


    @ManyToOne
    @JoinColumn(name = "id_sezione")
    private SezioneEntity sezioni;


    public ProdottoEntity() {}

    public ProdottoEntity(Long id, String descrizione, Integer prezzo, String codiceProdotto, Tipo tipo, Taglia taglia, ColoreEntity colore, Set<MaterialeEntity> materiali, SezioneEntity sezioni) {
        this.id = id;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.codiceProdotto = codiceProdotto;
        this.tipo = tipo;
        this.taglia = taglia;
        this.colore = colore;
        this.materiali = materiali;
        this.sezioni = sezioni;
    }
}

