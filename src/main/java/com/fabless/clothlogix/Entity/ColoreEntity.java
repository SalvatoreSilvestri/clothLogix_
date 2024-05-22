package com.fabless.clothlogix.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "colore")
public class ColoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name =  "descrizione")
    private String descrizione;


    public ColoreEntity() {}

    public ColoreEntity(Long id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }
}
