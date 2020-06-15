package br.edu.unisep.trainingmanager.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id_user")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "user")
    private UserRole role;
}
