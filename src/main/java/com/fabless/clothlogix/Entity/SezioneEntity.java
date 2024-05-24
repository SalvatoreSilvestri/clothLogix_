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
@Table(name = "sezione")
public class SezioneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name =  "scaffale")
    private String scaffale;

    @Column(name =  "fila")
    private String fila;


//    @JsonManagedReference("prodotto-sezione")
    @OneToMany(mappedBy = "sezione", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProdottoEntity> prodotto;


    public SezioneEntity(){}

    public SezioneEntity(Long id, String scaffale, String fila) {
        this.id = id;
        this.scaffale = scaffale;
        this.fila = fila;
    }
}
