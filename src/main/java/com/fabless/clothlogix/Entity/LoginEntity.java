package com.fabless.clothlogix.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;




@Getter
@Setter
@ToString
@Entity
@Table(name = "login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column (name = "password")
    private String password;

    public LoginEntity() {}

    public LoginEntity(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
