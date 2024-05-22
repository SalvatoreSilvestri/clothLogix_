package com.fabless.clothlogix.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;


@Getter
@Setter
@ToString
@Entity
@Table(name = "profili")
public class ProfiloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "can_create")
    private Boolean canCreate;

    @Column(name = "can_read")
    private Boolean canRead;

    @Column(name = "can_update")
    private Boolean canUpdate;

    @Column(name = "can_delete")
    private Boolean canDelete;


    @OneToMany
    @JoinColumn(name = "id_utenti")
    private Set<UtenteEntity> utenti;

    public ProfiloEntity() {}

    public ProfiloEntity(Long id, String descrizione, Boolean canCreate, Boolean canRead, Boolean canUpdate, Boolean canDelete, Set<UtenteEntity> utenti) {
        this.id = id;
        this.descrizione = descrizione;
        this.canCreate = canCreate;
        this.canRead = canRead;
        this.canUpdate = canUpdate;
        this.canDelete = canDelete;
        this.utenti = utenti;
    }
}
