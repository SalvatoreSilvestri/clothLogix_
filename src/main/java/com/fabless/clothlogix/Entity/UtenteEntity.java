package com.fabless.clothlogix.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@Data
@Getter
@Setter
@ToString
@Entity
@Table(name = "utente")
public class UtenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data")
    private Date dataDiNascita;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "citta")
    private String citta;

    @Column(name = "regione")
    private String regione;

    @Column(name = "cap")
    private String cap;

    @Column(name = "nazionalita")
    private String nazionalita;

    @OneToOne
    @JoinColumn(name = "id_login")
    private LoginEntity login;

    public UtenteEntity() {}

    public UtenteEntity(Long id, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta, String regione, String cap, String nazionalita, LoginEntity login) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.regione = regione;
        this.cap = cap;
        this.nazionalita = nazionalita;
        this.login = login;
    }
}
