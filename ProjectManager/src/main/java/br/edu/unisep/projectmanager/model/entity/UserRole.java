package br.edu.unisep.projectmanager.model.entity;

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
    @JoinColumn(name = "login")
    private User user;

    @OneToOne
    @JoinColumn(name = "id_role")
    private Role role;

}
