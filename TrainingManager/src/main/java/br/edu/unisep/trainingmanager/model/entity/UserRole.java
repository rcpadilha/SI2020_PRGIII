package br.edu.unisep.trainingmanager.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @Column(name = "id_userrole")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToOne
    @JoinColumn(name = "role_name")
    private Role role;

}
